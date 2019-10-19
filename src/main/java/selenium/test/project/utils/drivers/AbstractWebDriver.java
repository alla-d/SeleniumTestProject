package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;
import selenium.test.project.utils.CustomFileUtils;

import java.util.concurrent.TimeUnit;

public class AbstractWebDriver {

    public static String FIREFOX_WEBDRIVER_TYPE="firefox";
    public static String CHROME_WEBDRIVER_TYPE="chrome";

    protected CustomFileUtils customFileUtils;

    public AbstractWebDriver(){
        customFileUtils = new CustomFileUtils();
    }

    public static WebDriver getConfiguredDriver(
            WebDriver driver,
            long implicitlyWaitSeconds,
            boolean maximize) {
        driver.manage().timeouts().implicitlyWait(implicitlyWaitSeconds, TimeUnit.SECONDS);
        if(maximize)
            driver.manage().window().maximize();
        return driver;
    }
}
