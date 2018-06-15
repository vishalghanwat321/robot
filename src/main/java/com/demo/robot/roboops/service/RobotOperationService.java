package com.demo.robot.roboops.service;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  8:37 PM
 *
 */

import com.demo.robot.roboops.constant.GeneralConstant;
import com.demo.robot.roboops.domain.Robot;
import com.demo.robot.roboops.exception.*;
import com.demo.robot.roboops.repository.RobotOperationRepository;
import com.demo.robot.roboops.util.RobotUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RobotOperationService {

    @Autowired
    private RobotOperationRepository robotOperationRepository;


    public Robot configure(Robot robot) throws RobotAlreadyExistsAndConfiguredException {
        if (this.robotOperationRepository.existsById(robot.getRobotId()))
            throw new RobotAlreadyExistsAndConfiguredException("Robot already exists !!!");
        else
            return robotOperationRepository.save(robot);
    }

    public Robot query(Long id) throws RobotNotFoundException {
        if (!this.robotOperationRepository.existsById(id))
            throw new RobotNotFoundException("Robot not exists !!!");
        else
            return this.robotOperationRepository.findById(id).get();
    }

    public Robot workComputation(Double distance, Long weight, Robot robot) throws RobotDischargedException, OverWeightException, NotReachableException, TaskCanNotBePerformedException, UnsupportedOperationException {
        if (robot.getWeight() < weight)
            throw new OverWeightException("OverWeight !!! Task cannot be performed.");
        if (robot.getDistance() < distance)
            throw new NotReachableException("Not Reachable !!! Destination is too far.");
        if (robot.getBattery() <= 0)
            throw new RobotDischargedException("Battery Discharged !!! please recharge.");

        return this.updateRobotConfiguration(RobotUtility.batteryAfterTask(distance,weight,robot));
    }

    public Robot updateRobotConfiguration(Robot robot)
    {
        if (robot.getBattery() <= GeneralConstant.LOW_BATTERY_INDICATOR) {
            System.out.println("Low Battery !!! please recharge...");
            robot.setLowBatteryIndicator(true);
        }else
        {
            robot.setLowBatteryIndicator(false);
        }
        return this.robotOperationRepository.save(robot);
    }


    public void delete(Long id) throws RobotNotFoundException {
        if (!this.robotOperationRepository.existsById(id))
            throw new RobotNotFoundException("Robot not exists !!!");
        else
            this.robotOperationRepository.deleteById(id);
    }

}
