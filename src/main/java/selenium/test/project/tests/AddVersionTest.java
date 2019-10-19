package selenium.test.project.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.project.pages.*;
import selenium.test.project.utils.DataReader;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddVersionTest extends AbstractTest {
    private VersionsPage versionsPage;
    private AddVersionPage addVersionPage;



     @BeforeClass
    public void setUpClass(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        versionsPage = dashboardPage.openVersionsPage();
      log = LogManager.getLogger(this.getClass().getName());
          }

    @BeforeMethod
    public void setUpMethod(Method method){
        addVersionPage = versionsPage.openAddVersionsPage();
        log.info("Test '" + method.getName() +
                "' starts at: " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        extentTest = extentReports.startTest(method.getName());
    }


    @Test
    public void successAddVersionTest() {
                 addVersionPage = addVersionPage.fillAddVersionForm(
                "ver_" + new Date().getTime(),
                "sdfgbhjmgtrsefwqtrhj");
        versionsPage = addVersionPage.submitVersionForm();
        Assert.assertTrue(versionsPage.isInfoBoxDisplayed());
        log.info("add version");
    }

    @Test (dataProvider = "addVersionDataProvider")
    public void successAddVersionDataDrivenTest(String name, String description){
        addVersionPage = addVersionPage.fillAddVersionForm(
                name + "_" + new Date().getTime(), description);
        versionsPage = addVersionPage.submitVersionForm();

        Assert.assertTrue(versionsPage.isInfoBoxDisplayed());


    }


    @DataProvider(name ="addVersionDataProvider") //takes data from file.csv
    public Object[] [] dataProvider(){
        return new DataReader().readData("addversiondata.csv");
    }


//    @DataProvider(name ="addVersionDataProvider") // generate data which we can use for our tests
//    public Object [][] dataProvider(){
//        return new Object[][]
//                {
//                        {"abc", "description1"},
//                        {"def", "description2"},
//                        {"ghi", "description3"}
//                };
//    }

//    @Test
//    public void successAddVersionTest(){
//        Assert.assertTrue(
//                new DashboardPage(driver)
//                .openVersionsPage()
//                .openAddVersionsPage()
//                .fillAddVersionForm(
//                        "version_" + new Date().getTime(),
//                        "gkffddfdhshds")
//                .submitVersionForm()
//                .isInfoBoxDisplayed());
//    }
}
