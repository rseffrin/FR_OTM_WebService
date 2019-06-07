package br.com.frimesa.ws.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class Teste {
	
	
	public static final long HOUR = 3600*1000; // in milli-seconds.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(today);
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.getTime();
		
		Date newDate = DateUtils.addHours(today, 1);
		
		System.out.println("Data: "+newDate);
		


	}

}
