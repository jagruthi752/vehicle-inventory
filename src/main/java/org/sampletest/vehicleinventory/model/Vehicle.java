package org.sampletest.vehicleinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.sampletest.vehicleinventory.constant.VehicleType;

@Entity
@Table(name="vehicle_inventory")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="vehicle_type",nullable=false)
	@NotNull
	private VehicleType vehicleType;
	
	@Column(name="model",nullable=false)
	@NotNull
	private String model;
	
	@Column(nullable=false)
	@NotNull
	private String make;
	
	@Column(name="stock_on_hand")
	private Integer stockonHand;
	
	private String description;
	
	public Vehicle(VehicleType type, String model, String make, Integer quntity, String desc) {
		this.vehicleType = type;
		this.model = model;
		this.make = make;
		this.stockonHand = quntity;
		this.description = desc;
	}
	
	public Vehicle() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setStockonHand(Integer stockonHand) {
		this.stockonHand = stockonHand;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public Integer getStockonHand() {
		return stockonHand;
	}

	public String getDescription() {
		return description;
	}
}
