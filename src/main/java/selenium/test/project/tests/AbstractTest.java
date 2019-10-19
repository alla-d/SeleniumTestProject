package selenium.test.project.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.test.project.utils.BaseProperties;
import selenium.test.project.utils.CustomFileUtils;
import selenium.test.project.utils.CustomScreenshot;
import selenium.test.project.utils.DataGenerator;
import selenium.test.project.utils.drivers.WebDriverFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class AbstractTest {
    public static WebDriver driver;
    public static CustomFileUtils customFileUtils;
    public static CustomScreenshot customScreenshot;
    public static DataGenerator dataGenerator;
    public static Logger log;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    //path for drivers
    @BeforeSuite
    public void setUpSuite() {
        customFileUtils = new CustomFileUtils();
        customScreenshot = new CustomScreenshot();
        dataGenerator = new DataGenerator();
        extentReports = new ExtentReports(
                CustomFileUtils.getProjectPath() +
                        BaseProperties.REPORT_DIRECTORY +
                        BaseProperties.REPORT_NAME
                );
        extentReports.addSystemInfo("OS", "Windows");
        extentReports.addSystemInfo("Author", "Tester");
    }

    // initialisation WebDriver for all tests
    @BeforeTest
    @Parameters(("browser"))
    public void setUpTest(String browser) {
        driver = new WebDriverFactory().getDriver(
                browser,
                BaseProperties.IMPLISITLY_WAIT_SECOND,
                BaseProperties.WINDOW_MAXIMAZE);

        driver.get(BaseProperties.BASE_URL);
    }

    @BeforeClass
    public void setUpClass() {
        log = LogManager.getLogger(this.getClass().getName());
    }


    @AfterMethod
    @Parameters(("makeScreenshot"))
    public void tearDownMethod(ITestResult result, String makeScreenshot) {
        log.info("Test '" + result.getMethod().getMethodName() +
                "' ends at: " + new SimpleDateFormat(BaseProperties.LOG_DATE_FORMAT).format(new Date()));

        String screenshotFilePath = null;

        if (result.getStatus() == ITestResult.FAILURE) {
            screenshotFilePath = customScreenshot.makeScreenshot(driver, result.getMethod().getMethodName());
            extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() +
                    extentTest.addScreenCapture(screenshotFilePath));
            log.error("Test '" + result.getMethod().getMethodName() + "' finished with result: " + BaseProperties.TEST_RESULT_NAME[result.getStatus()]);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            if (makeScreenshot.equalsIgnoreCase(CustomScreenshot.MAKE_SCREENSHOT_ALWAYS))
                screenshotFilePath = customScreenshot.makeScreenshot(driver, result.getMethod().getMethodName());
            extentTest.log(LogStatus.PASS, result.getMethod().getMethodName() +
                    (screenshotFilePath != null ? extentTest.addScreenCapture(screenshotFilePath) : ""));
            log.info("Test '" + result.getMethod().getMethodName() + "' finished with result: " + BaseProperties.TEST_RESULT_NAME[result.getStatus()]);
        } else if (result.getStatus() == ITestResult.SKIP) {
            if (makeScreenshot.equalsIgnoreCase(CustomScreenshot.MAKE_SCREENSHOT_ALWAYS))
                screenshotFilePath = customScreenshot.makeScreenshot(driver, result.getMethod().getMethodName());
            extentTest.log(LogStatus.SKIP, result.getMethod().getMethodName() +
                    (screenshotFilePath != null ? extentTest.addScreenCapture(screenshotFilePath) : ""));
            log.info("Test '" + result.getMethod().getMethodName() + "' finished with result: " + BaseProperties.TEST_RESULT_NAME[result.getStatus()]);
        } else {
            if (makeScreenshot.equalsIgnoreCase(CustomScreenshot.MAKE_SCREENSHOT_ALWAYS))
                screenshotFilePath = customScreenshot.makeScreenshot(driver, result.getMethod().getMethodName());
            extentTest.log(LogStatus.UNKNOWN, result.getMethod().getMethodName() +
                    (screenshotFilePath != null ? extentTest.addScreenCapture(screenshotFilePath) : ""));
            log.info("Test '" + result.getMethod().getMethodName() + "' finished with result: " + BaseProperties.TEST_RESULT_NAME[0]);
        }

        extentReports.endTest(extentTest);
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownSuite(){
        extentReports.flush();
        extentReports.close();
    }
}

