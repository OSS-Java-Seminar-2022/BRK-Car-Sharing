package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<Page<Vehicle>> getAllVehiclesPaginated(Pageable pageable) {
        return ResponseEntity.ok(vehicleService.getAllVehiclesPaginated(pageable));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok("Successfully added vehicle!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getVehiclesInRange")
    public List<Vehicle> getVehiclesByLocation(List<Double> coordinates, int distance){
        return vehicleService.getVehiclesByLocation(coordinates, distance);
    }

}
