package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VersionsPage extends AbstractLayoutPage {


    @FindBy(xpath = "//a[@href='http://beta.demo.testarena.pl/Test67/add_version?filterAction=0&resultCountPerPage=&search=']")
    private WebElement addVersionButton;

    public VersionsPage(WebDriver driver){
        super(driver);
    }

    public AddVersionPage openAddVersionsPage(){
        clickElement(addVersionButton);
        return new AddVersionPage(driver);
    }

   }
