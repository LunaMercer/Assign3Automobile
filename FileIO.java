package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

import model.Automobile;

public class FileIO{
	//read a file and store its attributes in Automotive object
	public Automobile readFile(String fileName){
		Automobile automotive = null;
		try{
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			
			//read and store base price in automotive object
			if(!eof){
				String line = buff.readLine();
				if(line == null)
					eof = true;
				else{
					String[] retval = line.split(":");
					float basePrice = Float.parseFloat(retval[1]);
					automotive = new Automobile("Focus Wagon ZTW", basePrice, 5);
				}
			}
			while(!eof){
				final String line = buff.readLine();
				if(line == null)
					eof = true;
				else{
					final String[] lineParts = line.split(":");
					String[] options = lineParts[1].split(";");
					automotive.addOptionSet(lineParts[0].trim(), options.length);
					for(int i = 0; i < options.length; ++i){
						String[] optionAttributes = options[i].split(",");
						automotive.addOption(lineParts[0].trim(), optionAttributes[0].trim(), Float.parseFloat(optionAttributes[1]));
					}
				}
			}
			buff.close();
		} catch (IOException e){
			System.out.println("Error --" + e.toString());
		}
		return automotive;
	}
	//serialize Automotive object in a file
	public void serializeAuto(Automobile automotive){
		try{
			FileOutputStream fileOut = new FileOutputStream("auto.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(automotive);
			out.close();
			fileOut.close();
			System.out.println("Serialzed data is saved in auto.ser");
		} catch (IOException i){
			i.printStackTrace();
		}
	}
	//deserialize Automotive object from given file
	public Automobile deserializaAuto(String fileName){
		Automobile automobile = null;
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			automobile = (Automobile) in.readObject();
			in.close();
			fileIn.close();
			return automobile;
		} catch (IOException i){
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c){
			System.out.println("Automotive class not found");
			c.printStackTrace();
			return null;
		}
	}
}