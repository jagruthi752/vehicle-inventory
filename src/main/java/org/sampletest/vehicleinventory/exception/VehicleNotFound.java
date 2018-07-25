package org.sampletest.vehicleinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFound extends RuntimeException {
	public VehicleNotFound(Long id){
		super("Vehicle Not Found" +id + ",");
	}

}
