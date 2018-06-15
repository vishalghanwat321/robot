package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 15/06/18  9:27 AM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Battery is low, task can not be completed, please recharge your robot !!!")
public class TaskCanNotBePerformedException  extends  RuntimeException{

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public TaskCanNotBePerformedException(String errorMessage) {
        super(errorMessage);
    }
}
