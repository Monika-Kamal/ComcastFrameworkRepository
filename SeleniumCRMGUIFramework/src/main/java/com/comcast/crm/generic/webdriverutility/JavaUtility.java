package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
		
		public int getRandomNumber() {
			
			Random random = new Random();
			int randomInt = random.nextInt(4000);
			return randomInt;
		}
		
		public String getSystemdate() {
			Date dateobj = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String actDate = sim.format(dateobj);
			return actDate;
			
		}
		public String getRequiredDate(int days) {//passing int days because we are going to give required days before or after current date
			Date dateobj = new Date();
			
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String actDate = sim.format(dateobj);
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String reqDate = sim.format(cal.getTime());
			return reqDate;
			
		}

}
