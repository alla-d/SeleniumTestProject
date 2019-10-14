package selenium.test.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.project.pages.DashboardPage;

import java.util.Date;

public class AddVersionTest extends AbstractTest {

    @Test
    public void successAddVersionTest(){
        Assert.assertTrue(
                new DashboardPage(driver)
                .openVersionsPage()
                .openAddVersionsPage()
                .fillAddVersionForm(
                        "version_" + new Date().getTime(),
                        "gkffddfdhshds")
                .submitVersionForm()
                .isInfoBoxDisplayed());
    }
}
