package com.demo.robot.roboops.exception;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  11:41 PM
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Not Reachable !!! Destination is too far.")
public class NotReachableException extends RuntimeException {

    /**
     * Desired constructor.
     *
     * @param errorMessage The error message describing the exception.
     */
    public NotReachableException(String errorMessage) {
        super(errorMessage);
    }
}
