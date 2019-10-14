package selenium.test.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.project.pages.AddEnvironmentPage;
import selenium.test.project.pages.DashboardPage;
import selenium.test.project.pages.EnvironmentsPage;

import java.util.Date;


public class AddEnvironmentTest extends AbstractTest{

    @Test
    public void successAddEnvironmentTest() {

        DashboardPage dashboardPage = new DashboardPage(driver);
        EnvironmentsPage environmentsPage = dashboardPage.openEnviromentsPage();

        AddEnvironmentPage addEnvironmentPage = environmentsPage.openAddEnvironmentsPage();
        addEnvironmentPage = addEnvironmentPage.fillAddEnvironmentForm(
                "env_" + new Date().getTime(),
                "gkffddfdhshds");
        environmentsPage = addEnvironmentPage.submitAddEnvironmentForm();
        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
    }

//    @Test
//    public void successAddEnvironmentTest2(){
//        Assert.assertTrue(
//                new DashboardPage(driver)
//                .openEnvironmentsPage()
//                .openAddEnvironmentsPage()
//                .fillAddEnvironmentForm("", "")
//                .submitAddEnvironmentForm()
//                .isInfoBoxDisplayed());
//    }
}
