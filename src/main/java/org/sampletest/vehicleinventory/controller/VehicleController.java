package org.sampletest.vehicleinventory.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sampletest.vehicleinventory.constant.VehicleType;
import org.sampletest.vehicleinventory.exception.InvalidInputException;
import org.sampletest.vehicleinventory.exception.VehicleNotFound;
import org.sampletest.vehicleinventory.model.Vehicle;
import org.sampletest.vehicleinventory.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/inventory/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehicle getVehicle(@PathVariable(name="id") long id){
		Optional<Vehicle> optional = vehicleRepository.findById(id);
		return optional.orElseThrow(() -> new VehicleNotFound(id)) ;
	}

	@GetMapping("/count/{vehicletype}")
	public long getVehicleQuantity(@PathVariable String vehicletype){
		// validate input is a valid vehicleTyp
		VehicleType vtype = VehicleType.fromName(vehicletype);
		if(null == vtype){
			throw new InvalidInputException("vehicle type is not supported yet");
		}
		return vehicleRepository.quanityByVehicleType(vtype);
	}
	
	/* get method for searching for a vehicle and inventory
	 * this accepts extra filters like model and make 
	 */
	@GetMapping("search/{vehicletype}")
	public List<Vehicle> search(@PathVariable String vehicletype, 
			@RequestParam(name="model", required=false) String model, 
			@RequestParam(name="make", required=false) String make){
		
		VehicleType vtype = VehicleType.fromName(vehicletype);
		if(null == vtype){
			throw new InvalidInputException("vehicle type is not supported yet");
		}
		Vehicle input = new Vehicle();
		input.setVehicleType(vtype);
		input.setModel(model);
		input.setMake(make);
		
		return vehicleRepository.findAll(Example.of(input));
	}
	
	// create
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	// update quantity or any fields
	public Vehicle create(@Valid @RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	//update -patch
	@PatchMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		// check the vehicle exists
		Vehicle db = vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFound(id));
		this.mergeVehicle(db, vehicle);
		return vehicleRepository.save(db);
	}
	
	private void mergeVehicle(Vehicle db, Vehicle input) {
		if(input.getStockonHand() != null){
			db.setStockonHand(input.getStockonHand());
		}
		if(input.getDescription() != null) {
			db.setDescription(input.getDescription());
		}
	}

}
