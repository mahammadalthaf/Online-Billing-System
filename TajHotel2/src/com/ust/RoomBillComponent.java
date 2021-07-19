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
