package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IVehicleRepository extends MongoRepository<Vehicle,String> {
    List<Vehicle> getAvailableVehicles(String latitude, String longitude);
}
