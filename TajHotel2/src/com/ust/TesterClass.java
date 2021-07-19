package com.ust;

import java.util.Scanner;

public class TesterClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("*****Welcome to Holet Taj*****");

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
