package selenium.test.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.project.pages.DashboardPage;
import selenium.test.project.pages.LoginPage;
import selenium.test.project.utils.BaseProperties;


public class LoginTest extends AbstractTest{

    @Test
    public void successLoginTest(){
        // open login page
       LoginPage loginPage = new LoginPage(driver);
       // fill login and password
       loginPage = loginPage.fillLoginForm(
               BaseProperties.ADMIN_EMAIL,
               BaseProperties.ADMIN_PASSWORD);
       //click Log in
       DashboardPage dashboardPage = loginPage.submitLoginForm();
        // assert if login is successful
       Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());

    }
}
