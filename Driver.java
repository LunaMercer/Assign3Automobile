package model;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		/*
		 * Read file on the supplied pathname and deserializa Automotive object and read
		 * it into memory
		 */
		Automobile fordZTW;
		try {
			fordZTW = FileIO.deSerialization("FordZTW.txt");
			System.out.println("\nNew Automotive attributes are:");
			fordZTW.print();

			System.out.println("\nSearching Option Set by name 'color':");
			fordZTW.getOptionSetByName("color");

			System.out.println("\nSearching Option 'automatic' in Option Set 'transmission'");
			fordZTW.findOption("transmission", "automatic");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
