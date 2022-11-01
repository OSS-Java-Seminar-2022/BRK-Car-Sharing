package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {
    @Autowired
    private IVehicleRepository vehicleRepo;

    @PostMapping("/addVehicle")
    public String saveVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepo.save(vehicle);

        return "Added Successfully";
    }

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getAllVehicles() {

        return vehicleRepo.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable long id)
    {
        return vehicleRepo.findById(id);

    }

    @PatchMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> updateTutorial(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleData = vehicleRepo.findById(id);

        if (vehicleData.isPresent()) {
            Vehicle _vehicle = vehicleData.get();
            _vehicle.setMake(vehicle.getMake());
            return new ResponseEntity<>(vehicleRepo.save(_vehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable long id){
        vehicleRepo.deleteById(id);

        return "Deleted Successfully";
    }




}
