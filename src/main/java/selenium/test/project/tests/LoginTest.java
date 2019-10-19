package selenium.test.project.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.test.project.pages.DashboardPage;
import selenium.test.project.pages.LoginPage;
import selenium.test.project.utils.BaseProperties;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTest extends AbstractTest{

    @BeforeClass
    public void setUpClass(){
        log = LogManager.getLogger(this.getClass().getName());
    }

    @BeforeMethod
    public void setUpMethod(Method method){
        log.info("Test '" + method.getName() +
                "' starts at: " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        extentTest = extentReports.startTest(method.getName());
    }


    @Test
    public void successLoginTest(){

        customScreenshot.makeScreenshot(driver, "first");
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

// Sikuli
//        try {
//            s.click(CustomFileUtils.getProjectPath() +
//                    "/images/" +
//                    "user.png");
//            s.type("abcd");
//
//            s.click(CustomFileUtils.getProjectPath() +
//                    "/images/" +
//                    "password.png");
//            s.type("aaa");
//
//            s.click(CustomFileUtils.getProjectPath() +
//                    "/images/" +
//                    "ok.png");
//        } catch (FindFailed findFailed) {
//            findFailed.printStackTrace();
//        }
}
