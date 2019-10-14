package selenium.test.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddVersionPage extends AbstractLayoutPage{

    @FindBy (id="name")
    private WebElement nameField;

    @FindBy(id="description")
    private WebElement descriptionField;

    @FindBy(id="save")
    private WebElement saveButton;

    public AddVersionPage(WebDriver driver) {
        super(driver);
    }

    public AddVersionPage fillAddVersionForm(String name, String description){
        fillField(nameField,  name);

        if (description != null && description.length()>0){
            fillField(descriptionField, description);
        }
        return this;
    }

    public VersionsPage submitVersionForm(){
        clickElement(saveButton);
        return new VersionsPage(driver);
    }
}
