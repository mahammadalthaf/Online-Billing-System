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
