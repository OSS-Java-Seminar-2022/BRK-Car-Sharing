package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Repositories.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final IVehicleRepository vehicleRepository;

    public void addVehicle(Vehicle vehicle)
    {
        vehicleRepository.insert(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Page<Vehicle> getAllVehiclesPaginated(Pageable pageable){
        return vehicleRepository.findAll(pageable);
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Vehicle by ID - %s", id)));
    }
    public void updateVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.findById(vehicle.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Vehicle by ID %s", vehicle.getId())));
        savedVehicle.setId(vehicle.getId());
        savedVehicle.setMake(vehicle.getMake());
        savedVehicle.setModel(vehicle.getModel());

        vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }
    public List<Vehicle> getVehiclesByLocation(List<Double> coordinates, int distance){
        List<Vehicle> savedVehicles = vehicleRepository.findAll();
        return savedVehicles.stream().filter(add -> distance<sqrt(coordinates.get(0)+coordinates.get(1))).collect(Collectors.toList());
    }
}
