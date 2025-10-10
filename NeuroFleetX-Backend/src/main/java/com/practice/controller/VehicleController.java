package com.practice.controller;

import com.practice.entity.Vehicle;
import com.practice.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    // ✅ Constructor injection (no Lombok needed)
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
