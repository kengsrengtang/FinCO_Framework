package edu.mum.creditcard;

public class TotalMonthlyCharge implements Functor<Double, Double>{
	private double total;
	
	public TotalMonthlyCharge(){
		total = 0;
	}
	
	@Override
	public void compu(Double t) {
		total += t;
	}

	@Override
	public Double getResult() {
		return total;
	}

}
