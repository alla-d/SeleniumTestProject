package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractLayoutPage extends AbstractPage {

    @FindBy (xpath = "//div[@class='header_logout']") // //*[@id="head-top"]/div[2]/div[2]/a
    public WebElement logoutButton;

    public AbstractLayoutPage(WebDriver driver){
        super(driver);
    }

    public boolean isLogoutButtonDisplayed (){
        return isElementDisplayed(logoutButton);
    }

}
