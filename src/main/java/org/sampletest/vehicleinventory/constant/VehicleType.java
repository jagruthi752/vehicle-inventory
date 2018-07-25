package org.sampletest.vehicleinventory.constant;

import java.util.HashMap;
import java.util.Map;

public enum VehicleType {
	Car("car"),
	Truck("truck"),
	Airplane("airplane"),
	Amphibian("amphibian"),
	Boat("boat");
	
	String name;
	static Map<String, VehicleType> enumNameMap = new HashMap<>();
	VehicleType(String name){
		this.name=name;
	}
	
	static {
		for(VehicleType vehicleType : VehicleType.values()){
			enumNameMap.put(vehicleType.name, vehicleType);
		}
	}
	
	public static VehicleType fromName(String name) {
		return enumNameMap.get(name);
	}
}
