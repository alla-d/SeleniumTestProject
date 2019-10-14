package selenium.test.project.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public LoginPage fillLoginForm(String email, String password) {
        fillField(emailField, email);
        fillField(passwordField, password);
        return this;
    }


    public DashboardPage submitLoginForm() {
        clickElement(loginButton);
        return new DashboardPage(driver);
    }
}
