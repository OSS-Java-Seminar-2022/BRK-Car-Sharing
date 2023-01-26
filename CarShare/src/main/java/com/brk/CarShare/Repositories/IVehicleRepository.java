package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVehicleRepository extends MongoRepository<Vehicle,String> {

}
