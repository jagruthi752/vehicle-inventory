package org.sampletest.vehicleinventory.repository;

import java.util.List;

import org.sampletest.vehicleinventory.constant.VehicleType;
import org.sampletest.vehicleinventory.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByVehicleType(VehicleType vehicleType);
	@Query("select sum(stockonHand) from Vehicle where vehicleType = ?1 ")
	long quanityByVehicleType(VehicleType vehicleType);
}
