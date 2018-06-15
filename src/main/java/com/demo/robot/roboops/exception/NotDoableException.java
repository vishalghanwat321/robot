package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  11:08 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Unable to perform, recharge/update robot details.")
public class NotDoableException extends RuntimeException {
    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public NotDoableException(String errorMessage) {
        super(errorMessage);
    }
}
