# Online-Billing-System
Config files for my GitHub profile.

Hotel Online Billing
ABSTRACT:
This is a java program for online hotel booking and I have considered major user inputs like the name of a customer, type of room he/she wants, number of extra persons and number of days wants to stay in hotel. User will give the input from console if the type of room, number of extra persons and stay days doesn’t matches with conditions then particular error will be prompted on the console so for that, I have taken the abstract methods in my interface class and implemented them in main class and I have created a tester class to test my cases  and I took the user inputs if input matches all the conditions then bill will be calculated according to the input and it will be showed on the console.


















Data Flow diagram
 


CODE


 Interface: 

package com.ust;

public interface RoomBillComponent {

	public double Tax = 0.18;

	public double EXTRA_PERSON_CHARGE = 1500.00;

	public double FOOD_CHARGE = 1000.00;

	public boolean validateNoOfDaysOfStay();

	public boolean validateTypeOfRoom();

	public boolean validateNoOfExtraPerson();

	public double calculateBill();

}



RoomDetails class:

package com.ust;

public class RoomDetails implements RoomBillComponent {

	private int billId;

	private String customerName;

	private String typeOfRoomString;

	private int noOfExtraPerson;

	private int noOfDaysOfStay;

	private static int COUNTER = 101;

	public RoomDetails(String customerName, String typeOfRoomString, int noOfExtraPerson, int noOfDaysOfStay) {
		super();
		this.customerName = customerName;
		this.typeOfRoomString = typeOfRoomString;
		this.noOfExtraPerson = noOfExtraPerson;
		this.noOfDaysOfStay = noOfDaysOfStay;
		this.billId = COUNTER++;

	}

	public int getBillId() {
		return billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getTypeOfRoomString() {
		return typeOfRoomString;
	}

	public int getNoOfExtraPerson() {
		return noOfExtraPerson;
	}

	public int getNoOfDaysOfStay() {
		return noOfDaysOfStay;
	}

	@Override
	public boolean validateNoOfExtraPerson() {

		if (noOfExtraPerson >= 0 && noOfExtraPerson <= 2) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean validateTypeOfRoom() {

		if (typeOfRoomString.matches("Standard|Deluxe|Cottage")) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean validateNoOfDaysOfStay() {

		if (noOfDaysOfStay > 0 && noOfDaysOfStay <= 15) {
			return true;
		} else {

			return false;
		}

	}

	@Override
	public double calculateBill() {

		double totalBill = 0;

		if (!validateTypeOfRoom()) {
			System.out.println("\nPlease enter correct type of room (Standard|Deluxe|Cottage) ");

		} else if (!validateNoOfExtraPerson()) {
			System.out.println("\nNumber of persons shoud be 0 to 2");
		} else if (!validateNoOfDaysOfStay()) {
			System.out.println("\nNumber of days of stay should be in between 1 to 15 days only...");
		} else {

			double base_room_fare;
			if (typeOfRoomString.equals("Standard")) {
				base_room_fare = 5500;
			} else if (typeOfRoomString.equals("Deluxe")) {
				base_room_fare = 9000;
			} else {
				base_room_fare = 12000;
			}

			totalBill = (noOfDaysOfStay * base_room_fare) + noOfDaysOfStay * (FOOD_CHARGE)
					+ (EXTRA_PERSON_CHARGE * noOfExtraPerson);
			totalBill = totalBill + Tax * totalBill;

		}

		return totalBill;
	}

}




TesterClass:

package com.ust;

import java.util.Scanner;

public class TesterClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("*****Welcome to Hotel Taj*****");

		System.out.println("\nPlease enter name: ");

		String customerName = sc.nextLine();

		System.out.println("Enter the type of Room (Standard|Deluxe|Cottage)");

		System.out.println("Room fares are:\n1.Standard=5500 \n2.Deluxe=9000\n3.Cottage=12000 ");

		String typeOfRoom = sc.nextLine();

		System.out.println("Enter number of extra person");

		int noOfExtraPerson = sc.nextInt();

		System.out.println("Enter the no of day of stay");

		int noOfDaysOfStay = sc.nextInt();

		RoomDetails obj1 = new RoomDetails(customerName, typeOfRoom, noOfExtraPerson, noOfDaysOfStay);

		double TotalBill = obj1.calculateBill();

		if (TotalBill > 0) {
			System.out.println("\n*****Billing Deatis*****");

			System.out.println("BillID : " + obj1.getBillId());

			System.out.println("CustomerName : " + obj1.getCustomerName());

			System.out.println("No of days of stay : " + obj1.getNoOfDaysOfStay());

			System.out.println("Total Bill : " + TotalBill);

			System.out.println("\n*****Thank you*****");
		}

		sc.close();

	}
}




OUTPUT:
 
*****Welcome to Hotel Taj*****
Please enter name:
Althaf
Enter the type of Room (Standard|Deluxe|Cottage)
Room fares are:
1.Standard=5500
2.Deluxe=9000
3.Cottage=12000
Deluxe
Enter number of extra person
1
Enter the no of day of stay
3
 
*****Billing Deatis*****
BillID : 101
CustomerName : Althaf
No of days of stay : 3
Total Bill : 37170.0
 
*****Thank you*****
 

