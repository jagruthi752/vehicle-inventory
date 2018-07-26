package org.sampletest.vehicleinventory;

import org.sampletest.vehicleinventory.constant.VehicleType;
import org.sampletest.vehicleinventory.model.Vehicle;
import org.sampletest.vehicleinventory.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String [] args){
		SpringApplication.run(Application.class, args);
	}
	 @Bean
	 CommandLineRunner init(VehicleRepository repository) {
	      return (args) -> {
	    	  repository.save(new Vehicle(VehicleType.Car, "Honda", "Civic", 11, "Honda Civic LX 4 dr"));
	    	  repository.save(new Vehicle(VehicleType.Car, "Toyota", "Camry", 12, "Toyota Camry LE 4 dr"));
	    	  repository.save(new Vehicle(VehicleType.Truck, "Toyota", "Civic", 10, "Volvo Primer"));
	    	  repository.save(new Vehicle(VehicleType.Truck, "GMC", "Civic", 10, "Ford 150"));
	    	  repository.save(new Vehicle(VehicleType.Airplane, "Boeing", "777", 10, "Boeig 777 "));
	    	  repository.save(new Vehicle(VehicleType.Amphibian, "Argo", "ATV/UTV", 10, "Honda ATV R"));
	    	  repository.save(new Vehicle(VehicleType.Boat, "Chapparel", "300signature", 10, "Honda Civic LX 4 dr"));

	      };
	        
	 }
	
}
