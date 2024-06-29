package PageFactory.Repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		// path creation
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("WebResult");
		reporter.config().setReportName("PracticeTestResult");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;

	}

}
