package com.brk.CarShare.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.lang.reflect.Array;
import java.util.List;

@Document(collection = "trip")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tripId;
    private User user;
    private Vehicle vehicle;
    private String status;
    @Length(max = 2)
    private List startLocation;
    private String startTime;
    @Length(max = 2)
    private List endLocation;
    private String endTime;
    private String duration;
}
