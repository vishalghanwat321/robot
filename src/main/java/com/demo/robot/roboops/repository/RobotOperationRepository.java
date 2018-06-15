package com.demo.robot.roboops.repository;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  8:39 PM
 *
 */


import com.demo.robot.roboops.domain.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RobotOperationRepository extends CrudRepository<Robot, Long> {

}

