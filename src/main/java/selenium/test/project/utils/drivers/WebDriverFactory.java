package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public WebDriver getDriver(String driverType, long implicitlywaitSecond, boolean maximize) {

        WebDriver driver;

        if (driverType.equalsIgnoreCase(AbstractWebDriver.FIREFOX_WEBDRIVER_TYPE)) {
            driver = new CustomFirefoxDriver().getDriver();
        } else {
            driver = new CustomChromeDriver().getDriver();
        }

        return AbstractWebDriver.getConfiguredDriver(driver, implicitlywaitSecond, maximize);
    }
}
