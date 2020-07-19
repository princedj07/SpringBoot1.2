package com.springboot.rest.componenet;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
//	The following is a sample code that shows how to execute the task every minute starting at 9:00 AM and ending at 9:59 AM, every day
	
//   @Scheduled(cron = "0 * 9 * * ?")
//   public void cronJobSch() {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//      Date now = new Date();
//      String strDate = sdf.format(now);
//      System.out.println("Java cron job expression:: " + strDate);
//   }
   

//	A sample code for executing a task on every second from the application startup 
	
//   @Scheduled(fixedRate = 1000)
//   public void fixedRateSch() {
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//      Date now = new Date();
//      String strDate = sdf.format(now);
//      System.out.println("Fixed Rate scheduler:: " + strDate);
//   }
	
	
//	An example to execute the task for every second after 3 seconds from the application startup
	
	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	   public void fixedDelaySch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Fixed Delay scheduler:: " + strDate);
	   }
   
}