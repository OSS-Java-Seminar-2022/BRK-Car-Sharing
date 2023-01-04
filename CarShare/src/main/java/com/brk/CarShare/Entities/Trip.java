package com.brk.CarShare.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "trip")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tripId;
    private String userId;
    private String vehicleId;
    private String status;
    private String startLocation;
    private String startTime;
    private String endLocation;
    private String endTime;
    private String duration;
}
