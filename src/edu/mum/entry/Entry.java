package edu.mum.entry;

import java.util.Date;

public class Entry implements IEntry{
	Date date;
	double amount;
	public Entry(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
}
