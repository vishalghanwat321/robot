package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  11:50 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Battery Discharged !!! please recharge.")
public class RobotDischargedException extends RuntimeException {

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public RobotDischargedException(String errorMessage) {
        super(errorMessage);
    }
}