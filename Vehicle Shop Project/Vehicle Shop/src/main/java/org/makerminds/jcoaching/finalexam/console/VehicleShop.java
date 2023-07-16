package org.makerminds.jcoaching.finalexam.console;

import java.util.List;
import java.util.Scanner;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopPrinter;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * providing main method to start the application.
 * 
 * @author <Kadri Bajrami>
 *
 */
public class VehicleShop {

    private static final String VEHICLE_LIST_PATH = "/vehicle-list.txt"; 

	public static void main(String[] args) {
		
		// file reading
		VehicleFileManager vehicleFileManager = new VehicleFileManager(VEHICLE_LIST_PATH);
		List<String> vehicleDataAsStringList = vehicleFileManager.importVehiclesFromFile();
		
		// transformation into Vehicle Java Objects
		VehicleTransformer vehicleTransformer = new VehicleTransformer();
		List<Vehicle> vehicleList = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleDataAsStringList);
		
		// printing available vehicles 
		VehicleShopPrinter vehicleShopPrinter = new VehicleShopPrinter();
		vehicleShopPrinter.printAvailableVehicles(vehicleList);
		
		// user interaction - selecting a vehicle to sell
		Scanner scanner = new Scanner(System.in);
		vehicleShopPrinter.printVehicleIdToSellRequest();
		int vehicleChosenId = scanner.nextInt();
		 
		// selling a vehicle
		VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
		vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);
		
		// write new vehicle list back to file
		vehicleFileManager.rewriteFile(vehicleList);
		
		// print sold vehicle information and new vehicle list
		vehicleShopPrinter.printVehicleSoldMessage(vehicleChosenId);
		vehicleShopPrinter.printAvailableVehicles(vehicleList);
		scanner.close();
	}

		
	}
	

