package selenium.test.project.pages;

import org.omg.CORBA.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractLayoutPage extends AbstractPage {

    @FindBy (xpath = "//div[@class='header_logout']") // //*[@id="head-top"]/div[2]/div[2]/a
    public WebElement logoutButton;

    @FindBy(xpath = "//html/body/aside/div/ul/li[4]/a")
    public WebElement environmentsPage;

    @FindBy(id="j_info_box")
    public WebElement infoBox;

    @FindBy(xpath = "//html/body/aside/div/ul/li[5]/a")
    public WebElement versionsPage;

    public AbstractLayoutPage(WebDriver driver){
        super(driver);
    }

    public boolean isLogoutButtonDisplayed (){
        return isElementDisplayed(logoutButton);
    }

    public EnvironmentsPage openEnviromentsPage(){
        clickElement(environmentsPage);
        return new EnvironmentsPage(driver);
    }

    public boolean isInfoBoxDisplayed(){
        return isElementDisplayed(infoBox);
    }

    public VersionsPage openVersionsPage(){
        clickElement(versionsPage);
        return new VersionsPage(driver);
    }

    public Integer getMaxLengthAttribute(WebElement element){

        String maxLengthAttribute = element.getAttribute("maxLength");
        return maxLengthAttribute !=  null ? Integer.parseInt(element.getAttribute("maxLength")): 0;
    }
}

