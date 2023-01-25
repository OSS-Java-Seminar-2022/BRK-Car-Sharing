package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/add")
    public ResponseEntity addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok("Successfully added vehicle!");
    }


    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity getVehicleById(@PathVariable String id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

}
