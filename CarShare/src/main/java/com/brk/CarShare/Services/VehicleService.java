package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Repositories.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Vehicle by ID - %d", id)));
    }
    public void updateVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.findById(vehicle.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Vehicle by ID %s", vehicle.getId())));
        savedVehicle.setId(vehicle.getId());
        savedVehicle.setMake(vehicle.getMake());
        savedVehicle.setModel(vehicle.getModel());

        vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
