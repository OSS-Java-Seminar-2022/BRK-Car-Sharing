package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IVehicleRepository extends MongoRepository<Vehicle,String> {
}
