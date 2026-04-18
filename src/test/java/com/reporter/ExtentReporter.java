package com.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReporter {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport(){
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report/extents-report.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Extent Report");
        sparkReporter.config().setReportName("UCSC Automation");
        extent.attachReporter(sparkReporter);
    }

    public static void createTest(String testName){
        test = extent.createTest(testName);
    }

    public static void logPass(String message){
        if(Objects.nonNull(test)){
            test.log(Status.PASS,message);
        }
    }

    public static void logFail(String message){
        if(Objects.nonNull(test)){
            test.log(Status.FAIL,message);
        }
    }

    public static void logInfo(String message){
        if(Objects.nonNull(test)){
            test.log(Status.INFO,message);
        }
    }

    public static void flushReport(){
        if (Objects.nonNull(test)){
            extent.flush();
        }
    }
}
