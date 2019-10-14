package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;
import selenium.test.project.utils.CustomFileUtils;

import java.util.concurrent.TimeUnit;

public class AbstractWebDriver {

    protected CustomFileUtils customFileUtils;

    public AbstractWebDriver(){
        customFileUtils = new CustomFileUtils();
    }

    public WebDriver getConfiguredDriver(
            WebDriver driver,
            long implicitlyWaitSeconds,
            boolean maximize) {
        driver.manage().timeouts().implicitlyWait(implicitlyWaitSeconds, TimeUnit.SECONDS);
        if(maximize)
            driver.manage().window().maximize();
        return driver;
    }
}
