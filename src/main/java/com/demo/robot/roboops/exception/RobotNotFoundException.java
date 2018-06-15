package com.demo.robot.roboops.exception;


/*
 *
 *  @project Robot
 *
 *  @author vishal on 14/06/18  8:33 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Robot not found")
public class RobotNotFoundException extends RuntimeException {

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public RobotNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

