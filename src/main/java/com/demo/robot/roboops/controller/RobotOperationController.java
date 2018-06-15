package com.demo.robot.roboops.controller;


/*
 *
 *  @project Robot
 *
 *  @author vishal on 14/06/18  8:32 PM
 *
 */

import com.demo.robot.roboops.constant.ApiPathConfigs;
import com.demo.robot.roboops.constant.GeneralConstant;
import com.demo.robot.roboops.domain.Robot;
import com.demo.robot.roboops.exception.*;
import com.demo.robot.roboops.service.RobotOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@DependsOn("robotOperationService")
@RequestMapping(value = ApiPathConfigs.ROBOT_BASE_PATH)
public class RobotOperationController {

    @Autowired
    private RobotOperationService robotOperationService;

    @PostMapping(value = "/create", consumes = GeneralConstant.CONSUMES, produces = GeneralConstant.PRODUCES)
    public @ResponseBody
    Robot createRobotConfiguration(@Valid @RequestBody Robot robot) throws IllegalArgumentException, RobotAlreadyExistsAndConfiguredException {

        if (Objects.isNull(robot))
            throw new IllegalArgumentException("Please provide robot details to configure new robot");
        if (Objects.isNull(robot.getRobotId()) || Objects.isNull(robot.getBattery()) || Objects.isNull(robot.getDistance()) || Objects.isNull(robot.getWeight()))
            throw new IllegalArgumentException("Please provide information like id, battery, distance, weight");
        return this.robotOperationService.configure(
                Robot.builder().
                        robotId(robot.getRobotId()).
                        battery(robot.getBattery()).
                        distance(robot.getDistance()).
                        weight(robot.getWeight())
                        .build());
    }

    @PutMapping(value = "/{id}", consumes = GeneralConstant.CONSUMES, produces = GeneralConstant.PRODUCES)
    public @ResponseBody
    Robot assignWorkToRobot(@PathVariable(value = "id") Long id,
                            @RequestParam(value = "distance", defaultValue = "0") Double distance,
                            @RequestParam(value = "weight", defaultValue = "0") Long weight) throws  RobotNotFoundException, RobotDischargedException, OverWeightException, NotReachableException, TaskCanNotBePerformedException, UnsupportedOperationException  {
        Robot robot = this.robotOperationService.query(id);
        return this.robotOperationService.workComputation(distance, weight,robot);
    }

    @PutMapping(value = "/{id}/update", consumes = GeneralConstant.CONSUMES, produces = GeneralConstant.PRODUCES)
    public @ResponseBody
    Robot updateRobotConfiguration(@PathVariable(value = "id") Long id,
                        @RequestParam(value = "battery", defaultValue = "100") Double battery,
                        @RequestParam(value = "distance", defaultValue = "5") Double distance,
                        @RequestParam(value = "weight", defaultValue = "10") Long weight) throws RobotNotFoundException {
        Robot robot = this.robotOperationService.query(id);
        robot.setDistance(distance);
        robot.setWeight(weight);
        robot.setBattery(battery);
        return this.robotOperationService.updateRobotConfiguration(robot);
    }

    @DeleteMapping(value = "/{id}/delete")
    public @ResponseBody
    boolean deleteRobot(@PathVariable(value = "id") Long id) throws IllegalArgumentException, RobotNotFoundException {
        if (Objects.isNull(id))
            throw new IllegalArgumentException("Robot id can not be null or 0");
        this.robotOperationService.delete(id);
        return  true;
    }
}
