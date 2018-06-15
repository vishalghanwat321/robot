package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  11:20 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "OverWeight !!! Task cannot be performed.")
public class OverWeightException extends RuntimeException {

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public OverWeightException(String errorMessage) {
        super(errorMessage);
    }
}
