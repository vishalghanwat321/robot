package com.demo.robot.roboops.util;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  8:40 PM
 *
 */


import com.demo.robot.roboops.domain.Robot;
import com.demo.robot.roboops.exception.NotReachableException;
import com.demo.robot.roboops.exception.TaskCanNotBePerformedException;

import java.awt.dnd.InvalidDnDOperationException;

public class RobotUtility {

    public static Robot batteryAfterTask(Double distance, Long weight, Robot robot) throws TaskCanNotBePerformedException, UnsupportedOperationException
    {
        if (distance==0 && weight ==0)
            return robot;
        else if(distance!=0 && weight==0)
            return RobotUtility.taskWithOnlyDistance(distance,robot);
        else if(distance!=0 && weight !=0)
            return RobotUtility.taskWithDistanceAndWeight(distance,weight,robot);
        else
             throw new UnsupportedOperationException("Unsupported Operation !!!");
    }

    public static Robot taskWithOnlyDistance(Double distance, Robot robot) throws  TaskCanNotBePerformedException, NotReachableException
    {
        Double distanceCoveredPerPercent = (robot.getDistance()/robot.getBattery());
        Double consumedBattery = (distance / distanceCoveredPerPercent);

        if(consumedBattery > robot.getBattery())
        {
            throw new TaskCanNotBePerformedException("Battery is low, task can not be completed, please recharge your robot !!!");
        }else
        {
            if((robot.getBattery() - consumedBattery) < 0.0)
                throw new NotReachableException("Not Reachable !!! Destination is too far and Battery is too low to perform this action !!!");

            robot.setBattery(robot.getBattery() - consumedBattery);
            robot.setDistance(robot.getDistance() - distance);
        }
        return robot;
    }

    public static Robot taskWithDistanceAndWeight(Double distance, Long weight, Robot robot) throws TaskCanNotBePerformedException
    {
        Double distanceCoveredPerPercent = (robot.getDistance()/robot.getBattery());
        Double consumedBattery = ((distance / distanceCoveredPerPercent) + (weight * 2));

        if(consumedBattery > robot.getBattery())
        {
            throw new TaskCanNotBePerformedException("Battery is low, task can not be completed, please recharge your robot !!!");
        }else
        {
            if((robot.getBattery() - consumedBattery) < 0.0)
                throw new NotReachableException("Not Reachable !!! Destination is too far and Battery is too low to perform this action !!!");

            robot.setBattery(robot.getBattery() - consumedBattery);
            robot.setDistance(robot.getDistance() - distance);
        }
        return robot;
    }
}
