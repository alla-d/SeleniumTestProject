package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.test.project.utils.BaseProperties;


public class CustomChromeDriver extends AbstractWebDriver implements CustomWebDriver{


    @Override
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",
                customFileUtils.getResourceFilePathString(BaseProperties.CHROME_DRIVER));
        return new ChromeDriver();
    }



}
