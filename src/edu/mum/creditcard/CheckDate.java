package edu.mum.creditcard;

import java.util.Calendar;
import java.util.Date;

public class CheckDate implements Predicate<Date> {

	@Override
	public boolean check(Date t) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(t);

		Calendar cal2 = Calendar.getInstance();
		Date today = new Date();
		cal2.setTime(today);

		return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
	}

}
