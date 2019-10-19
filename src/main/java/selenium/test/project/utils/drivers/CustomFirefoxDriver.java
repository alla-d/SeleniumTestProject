package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.test.project.utils.BaseProperties;


public class CustomFirefoxDriver extends AbstractWebDriver implements CustomWebDriver {
    @Override
    public WebDriver getDriver(){
        System.setProperty("geckodriver.chrome.driver",
                customFileUtils.getResourceFilePathString(BaseProperties.FIREFOX_DRIVER));
        return new FirefoxDriver();
    }

}
