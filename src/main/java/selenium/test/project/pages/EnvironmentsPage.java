package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.test.project.tests.AddEnvironmentTest;

public class EnvironmentsPage extends AbstractLayoutPage {

    @FindBy (xpath = "//html/body/div[1]/section/article/div[1]/nav/ul/li/a") // '//a[@href="http://beta.demo.testarena.pl/Test67/add_environment"]'
    private WebElement addEnvironmentButton;

    public EnvironmentsPage (WebDriver driver){
        super(driver);
    }

    public AddEnvironmentPage openAddEnvironmentsPage(){
        clickElement(addEnvironmentButton);
        return new AddEnvironmentPage(driver);
    }


}
