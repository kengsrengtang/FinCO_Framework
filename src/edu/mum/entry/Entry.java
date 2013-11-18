package edu.mum.entry;

import java.util.Date;

public class Entry implements IEntry{
	private Date date;
	private double amount;
	public Entry(Date date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
	@Override
	public Date getDate() {
		return date;
	}
}
