package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected static WebDriver driver; // static because Selenium sometimes loose driver

    // this is constructor for initialisation elements
    public AbstractPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void clickElement(WebElement element){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
