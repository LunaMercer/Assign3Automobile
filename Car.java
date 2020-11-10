package model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Car implements Driveable {

	int vNumber, year, miles;
	int speed;
	int gear;
	String make;
	double price;
//	String EXISTING_MAKES[] = { "Ford", "Honda", "Toyota", "Chrysler", "Other" };
	static enum EXISTING_MAKES {
		Ford, Honda, Toyota, Chrysler, Other
	}

	public Car(int vNumber, String make, int year, int miles, double price) throws CarException {
		setVNumber(vNumber);
		if (vNumber < 1000 || vNumber > 9999)
			throw (new CarException());
		setMake(make);

		if (this.checkIfModelExists(make) != true) {
			throw (new CarException());
		}

		setYear(year);
		if (year < 1990 || year > 2014)
			throw (new CarException());

		setMiles(miles);
		if (miles < 0)
			throw (new CarException());

		setPrice(price);
		if (price < 0)
			throw (new CarException());
	}

	public boolean checkIfModelExists(String make) {
		boolean exists = false;
		if (make.equalsIgnoreCase(Car.EXISTING_MAKES.Ford.toString()) || make.equalsIgnoreCase(Car.EXISTING_MAKES.Honda.toString()) || 
				make.equalsIgnoreCase(Car.EXISTING_MAKES.Toyota.toString()) || make.equalsIgnoreCase(Car.EXISTING_MAKES.Chrysler.toString()) || make.equalsIgnoreCase(Car.EXISTING_MAKES.Other.toString())) {
			exists = true;
		}
		return exists;
	}

	public void setVNumber(int vNumber) {
		this.vNumber = vNumber;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVNumber() {
		return vNumber;
	}

	public String getMake() {
		return make;
	}

	public int getYear() {
		return year;
	}

	public int getMiles() {
		return miles;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public void drive() {
		System.out.println("Car is in drive mode");
	}

	@Override
	public void stop() {
		System.out.println("Car is in stop mode");
	}

	@Override
	public void reverse() {
		System.out.println("Car is in reverse mode");
	}

	@Override
	public void speedUp(int a) {
		this.speed = a;
		System.out.println("speed" + speed);
	}

	@Override
	public void changeGear(int a) {
		this.gear = a;
		System.out.println("gear" + gear);
	}

	public static void main(String[] args) {

		Car obj = null;
		try {
			obj = new Car(1500, "Other", 2001, 78340, 5999.99);
		} catch (CarException ex) {
			Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
		}
		obj.drive();
		obj.stop();
		obj.reverse();
		obj.changeGear(2);
		obj.speedUp(70);
		
//		System.out.println(Car.EXISTING_MAKES.Toyota.toString());
	}

}