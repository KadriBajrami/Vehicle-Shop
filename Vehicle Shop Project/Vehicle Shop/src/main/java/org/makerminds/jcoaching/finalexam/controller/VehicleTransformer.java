package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;


import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Color;
import org.makerminds.jcoaching.finalexam.model.FuelType;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Transmission;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for transforming vehicle data into {@link Vehicle} objects.
 * 
 * @author <Kadri Bajrami>
 *
 */
public class VehicleTransformer {
	
	/**
	 * transforms a data array into a {@link Vehicle} list 
	 * @param vehicle data array
	 * @return list of {@link Vehicle} objects
	 */
	public List<Vehicle> transformDataArrayToVehicleObjects(List<String> vehicleDataArray) {
		// TODO take data from String list and transform to list of vehicle objects
		// TODO call method transformToVehicleObject
		// Hint: use for loop
		List<Vehicle> vehicleList = new ArrayList<>();
		for(String vehicleAsString : vehicleDataArray) {
			Vehicle vehicle = transformToVehicleObject(vehicleAsString);
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}

	/**
	 * transforms a vehicle data record as String into a {@link Vehicle} object
	 * @param vehicle data record as String 
	 * @return {@link Vehicle} object
	 */
	private Vehicle transformToVehicleObject(String vehicleAsString) {
		// TODO transform the vehicle as string into a vehicle object
		// Hint: use the split(String) method of a String to define where to split the 
		// String. In this case split on every comma (,)
		String[] vehicleAsArray = vehicleAsString.split(",");
		int id = Integer.valueOf(vehicleAsArray[0]);
		Manufacturer manufacturer = getManufacturerFromString(vehicleAsArray[1]);
		String model = vehicleAsArray[2];
		int horsePower = Integer.parseInt(vehicleAsArray[3]);
		double price = Double.valueOf(vehicleAsArray[4]);
		Color color = getColorFromString(vehicleAsArray[5]);
		int mileage = Integer.parseInt(vehicleAsArray[6]);
		int productionYear = Integer.valueOf(vehicleAsArray[7]);
		FuelType fuelType = getFuelTypeFromString(vehicleAsArray[8]);
		Transmission transmission = getTransmissionFromString(vehicleAsArray[9]);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setId(id);
		vehicle.setManufacturer(manufacturer);
		vehicle.setModel(model);
		vehicle.setHorsePower(horsePower);
		vehicle.setPrice(price);
		vehicle.setColor(color);
		vehicle.setMileage(mileage);
		vehicle.setProductionYear(productionYear);
		vehicle.setFuelType(fuelType);
		vehicle.setTransmission(transmission);
 		
		return vehicle;
	}

	private Manufacturer getManufacturerFromString(String manufacturerLikeString) {
		for(Manufacturer manufacturer : Manufacturer.values()) {
			if(manufacturer.name().equals(manufacturerLikeString)) {
				return manufacturer;
			}
		}
		throw new IllegalArgumentException("ManuFacturer not supporded:" + manufacturerLikeString);
	}
	
	private Color getColorFromString(String colorAsString) {
		for(Color color : Color.values()) {
			if(color.name().equals(colorAsString)) 
				return color;
			}
		
		throw new IllegalArgumentException("Color not supported: " + colorAsString);
         
		}
	
	
	private FuelType getFuelTypeFromString(String fuelTypeAsString) {
		for(FuelType fuelType : FuelType.values()) {
			
			if(fuelType.name().equals(fuelTypeAsString)) 
				return fuelType;
			}
		
		throw new IllegalArgumentException("Fuel type not supported: " + fuelTypeAsString);
		
}
	
	private Transmission getTransmissionFromString(String transmissionAsString) {
		for(Transmission transmission : Transmission.values()) {
			if(transmission.name().equals(transmissionAsString)) 
				
				return transmission;
			}
		
		throw new IllegalArgumentException("Transmission not supported: " + transmissionAsString);
	}
}









