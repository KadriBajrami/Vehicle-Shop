package org.makerminds.jcoaching.finalexam.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


import java.util.List;
import java.nio.file.Path;


import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * managing the file.
 * 
 * @author <Kadri Bajrami>
 *
 */
public class VehicleFileManager {
	
	private String filePath;
	
	public VehicleFileManager(String filePath) {
		this.filePath = filePath;
	}
	
	public List<String> importVehiclesFromFile() {
		// TODO read vehicle-list-txt and transform to String array
		// Hint: use java.nio.file.Files and Paths class
		try {
			return Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
		} catch (IOException | URISyntaxException e) {
		    throw new RuntimeException("An error occured while importing!", e);
		}
	}
	
	public void rewriteFile(List<Vehicle> vehicleList) {
		// TODO write back into vehicle-list-txt and transform to String array
		// TODO call method prepareTheVehicleForRewriting(StringBuffer, Vehicle)
		// Hint: use java.nio.file.Path and java.nio.file.Paths class
		
		StringBuffer vehicleStringForRewrite = new StringBuffer();
		Iterator<Vehicle> Iterator = vehicleList.iterator();
		while(Iterator.hasNext()) {
			Vehicle vehicle = Iterator.next();
			prepareTheVehicleForRewriting(vehicleStringForRewrite, vehicle);
			vehicleStringForRewrite.append("\r\n");
		}
		try {
			
		Path path = Paths.get(getClass().getResource(filePath).toURI());
		Files.writeString(path, vehicleStringForRewrite.toString());
	} catch (IOException | URISyntaxException e) {
		throw new RuntimeException(" An error ocurred while writting the file ", e);
	}
	
}

	private void prepareTheVehicleForRewriting(StringBuffer vehicleStringForRewrite, Vehicle vehicle) {
		// TODO add vehicle attribute information to StringBuffer
		// Hint: vehicleStringForRewrite.append(String)
		vehicleStringForRewrite.append(vehicle.getId());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getManufacturer());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append( vehicle.getModel());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getHorsePower());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getPrice());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getColor());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getMileage());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getProductionYear());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getFuelType());
		vehicleStringForRewrite.append(",");
		vehicleStringForRewrite.append(vehicle.getTransmission());
		vehicleStringForRewrite.append(",");
		
	}

}








