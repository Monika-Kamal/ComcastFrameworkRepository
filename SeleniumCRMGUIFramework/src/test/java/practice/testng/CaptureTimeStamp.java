package practice.testng;

import java.util.Date;

import org.testng.annotations.Test;

public class CaptureTimeStamp {
	@Test
	public void timeStampTest(){
		String time=new Date().toString();
		System.out.println(time.replace(" ", "_").replace(":", "_"));
	}

}
