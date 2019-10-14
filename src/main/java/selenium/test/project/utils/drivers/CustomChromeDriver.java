package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.test.project.utils.BaseProperties;
import selenium.test.project.utils.CustomFileUtils;

import static selenium.test.project.tests.AbstractTest.customFileUtils;


public class CustomChromeDriver extends AbstractWebDriver implements CustomWebDriver{


    @Override
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",
                customFileUtils.getResourceFilePath(BaseProperties.CHROME_DRIVER));
        return new ChromeDriver();
    }



}
