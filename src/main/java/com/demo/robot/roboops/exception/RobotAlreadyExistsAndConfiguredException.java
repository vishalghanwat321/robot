package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  9:45 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Robot already exists and configured.")
public class RobotAlreadyExistsAndConfiguredException extends RuntimeException {

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public RobotAlreadyExistsAndConfiguredException(String errorMessage) {
        super(errorMessage);
    }

}
