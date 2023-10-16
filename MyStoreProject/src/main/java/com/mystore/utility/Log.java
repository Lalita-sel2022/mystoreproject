package com.mystore.utility;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.mystore.base.BaseClass;

public class Log extends BaseClass
{
	//Initialize log4j logs
	//public  static Logger logger= LogManager.getLogger(Log.class.getName());
	
	public  static Logger logger = Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName){		  
		logger.info("====================================="+sTestCaseName+" TEST START=========================================");
		 }
	
	public static void endTestCase(String sTestCaseName){
		logger.info("====================================="+sTestCaseName+" TEST END=========================================");
		 }
	
	// Need to create below methods, so that they can be called  

	 public static void info(String message) {

		 test.log(Status.INFO, message);
		 //logger.info(message);
		 

			}

	 public static void fail(String message) {

		 test.log(Status.FAIL, message);
		 //logger.warn(message);

		}

	 public static void pass(String message) {

		 test.log(Status.PASS, message);
		 // logger.error(message);

		}

	 public static void skip(String message) {

		 test.log(Status.SKIP, message);
		// logger.fatal(message);

		}
	

	 public static void warn(String message) {

		 test.log(Status.WARNING, message);
		// logger.debug(message);

		}

}
