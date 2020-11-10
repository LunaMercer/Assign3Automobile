package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
	/**
	 * This method is used to read data from file for deSerialization.
	 * 
	 * @param filePathName
	 * @return Deserialized object from file input
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Automobile deSerialization(String filePathName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePathName);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return (Automobile)object;
	}

	/**
	 * This method is used to write automobile data to file for Serialization.
	 * 
	 * @param filePathName
	 * @param object
	 * @throws IOException
	 */
	public static void serialization(String filePathName, Automobile object) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(filePathName);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
		objectOutputStream.writeObject(object);
		objectOutputStream.close();
	}
}
