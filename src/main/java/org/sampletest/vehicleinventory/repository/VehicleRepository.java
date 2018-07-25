package org.sampletest.vehicleinventory.repository;

import java.util.List;

import org.sampletest.vehicleinventory.constant.VehicleType;
import org.sampletest.vehicleinventory.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByVehicleType(VehicleType vehicleType);
	long countByVehicleType(VehicleType vehicleType);
}
