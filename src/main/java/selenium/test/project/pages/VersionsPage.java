package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VersionsPage extends AbstractLayoutPage {


    @FindBy(xpath = "//*[@id=\"content\"]/article/div[1]/nav/ul/li/a") // '//a[@href="http://beta.demo.testarena.pl/Test67/versions"]' //a[@href='http://beta.demo.testarena.pl/Test67/versions']
    private WebElement addVersionButton;

    public VersionsPage(WebDriver driver){
        super(driver);
    }

    public AddVersionPage openAddVersionsPage(){
        clickElement(addVersionButton);
        return new AddVersionPage(driver);
    }

   }
