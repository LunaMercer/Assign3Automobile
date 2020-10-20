package driver;

import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String[] args){
		FileIO file = new FileIO();
		Automobile FordZTW = file.readFile("FordZTW.txt");
		
		System.out.println("Print attributes before serialization");
		FordZTW.print();
		
		//Serialize Automotive object
		file.serializeAuto(FordZTW);
		
		//Deserialize Automotive object and read it into memory
		Automobile newFordXTW = file.deserializeAuto("auto.ser");
		System.out.println("\nNew Automotive attributes are:");
		newFordXTW.print();
		
		System.out.println("\nSearching Option Set by name 'color':");
		newFordXTW.findOptionSet("color");
		
		System.out.println("\nSearching Option 'automatic' in Option Set 'transmission'");
		FordZTW.findOption("transmission", "automatic");
	}

}
