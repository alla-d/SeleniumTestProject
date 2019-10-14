package selenium.test.project.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import selenium.test.project.utils.BaseProperties;
import selenium.test.project.utils.CustomFileUtils;
import selenium.test.project.utils.drivers.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    public static WebDriver driver;
    public static CustomFileUtils customFileUtils;

//path for drivers
    @BeforeSuite
    public void setUpSuite(){
        customFileUtils = new CustomFileUtils();
    }

        // init WebDriver for all tests
    @BeforeTest
    public void setUpTest(){
        driver = new WebDriverFactory().getDriver("firefox");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(BaseProperties.BASE_URL);
    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();
    }
}

