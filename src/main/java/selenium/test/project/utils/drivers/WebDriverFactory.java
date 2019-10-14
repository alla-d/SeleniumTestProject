package selenium.test.project.utils.drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public WebDriver getDriver(String driverType) {

        WebDriver driver;

        if (driverType.equalsIgnoreCase("firefox")) {
            driver = new CustomFirefoxDriver().getDriver();
        } else {
            driver = new CustomChromeDriver().getDriver();
        }
        return driver;
    }
}
