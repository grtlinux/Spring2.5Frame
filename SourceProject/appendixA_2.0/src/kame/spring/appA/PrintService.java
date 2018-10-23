package kame.spring.appA;

import java.text.DateFormat;
import java.util.Date;

public class PrintService {

	private DateFormat dateFormat;

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void printToday() {
		System.out.println(dateFormat.format(new Date()));
	}
	
}
