package edu.mum.util;

public class FincoRandom {
	private static int defaultNo = 10000;
	public static int nextUniqueId(){
		return defaultNo++;
	}
}
