//package com.ash.utils;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.testng.annotations.AfterSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//
//public class ExtentTestManager {
//	private static Map<Integer, ExtentTest> testMap = new HashMap<>();
//    private static ExtentReports extent = ExtentManager.getInstance();
//
//    public synchronized ExtentTest getTest() {
//        return testMap.get((int) Thread.currentThread().getId());
//    }
//
//    public static synchronized ExtentTest startTest(Method method) {
//        ExtentTest test = extent.createTest(method.getName());
//        testMap.put((int) Thread.currentThread().getId(), test);
//       // test.pass("shows the details");
//        test.log(Status.PASS, "Details");
//        test.log(Status.INFO, "this step shows usage of log(status)");
//        test.log(Status.FAIL, "test is failed");
//        //test.info("shows the infor details");
//        test.fail("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//        
//        test.addScreenCaptureFromPath("screenshot.png");
//        
//        
//        
//        return test;
//    }
//    
//    @AfterSuite
//    public void tearDown() {
//    	extent.flush();
//    }
//
//
//}
