package com.demo.robot.roboops.domain;


/*
 *
 *  @project robot
 *
 *  @author vishal on 14/06/18  8:39 PM
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@Cacheable(false)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Robot implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @JsonProperty("id")
    @Getter
    private Long robotId;

    @NotNull
    @Column(name = "weight", nullable = false)
    @JsonProperty("weight")
    @Getter
    @Setter
    private Long weight;

    @NotNull
    @Column(name = "distance", nullable = false)
    @JsonProperty("distance")
    @Getter
    @Setter
    private Double distance;

    @NotNull
    @Column(name = "battery", nullable = false)
    @JsonProperty("battery")
    @Getter
    @Setter
    private Double battery;

    @Column(name = "low_battery_indicator")
    @Getter
    @Setter
    @JsonIgnore
    private Boolean lowBatteryIndicator;

    @Column(name = "creation_timestamp", columnDefinition = "TIMESTAMP", updatable = false, nullable = false)
    @Getter
    @JsonIgnore
    private LocalDateTime creationTimestamp;

    @Column(name = "last_modification_timestamp", columnDefinition = "TIMESTAMP")
    @Getter
    @JsonIgnore
    private LocalDateTime lastModificationTimestamp;

    @PrePersist
    protected void onPrePersist() {
        this.creationTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.lastModificationTimestamp = LocalDateTime.now();
    }


}
