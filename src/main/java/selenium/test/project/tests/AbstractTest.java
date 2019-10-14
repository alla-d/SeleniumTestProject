package selenium.test.project.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import selenium.test.project.utils.BaseProperties;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    public static WebDriver driver;


    // init WebDriver for all tests
    @BeforeTest
    public void setUpTest(){
        System.setProperty("webdriver.chrome.driver",
                BaseProperties.CHROMEDRIVER_PATH);
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

