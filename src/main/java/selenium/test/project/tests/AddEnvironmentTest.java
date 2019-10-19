package selenium.test.project.tests;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.project.pages.AddEnvironmentPage;
import selenium.test.project.pages.DashboardPage;
import selenium.test.project.pages.EnvironmentsPage;
import selenium.test.project.utils.DataReader;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddEnvironmentTest extends AbstractTest{

    private EnvironmentsPage environmentsPage;
    private AddEnvironmentPage addEnvironmentPage;

    @BeforeClass
    public void setUpClass(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        environmentsPage = dashboardPage.openEnviromentsPage();
        log = LogManager.getLogger(this.getClass().getName());

    }

    @BeforeMethod
    public void setUpMethod(Method method){
        addEnvironmentPage = environmentsPage.openAddEnvironmentsPage();
        log.info("Test '" + method.getName() +
                "' starts at: " +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        extentTest = extentReports.startTest(method.getName());
    }


    @Test
    public void successAddEnvironmentTest() {
        addEnvironmentPage = addEnvironmentPage.fillAddEnvironmentForm(
                "env_" + new Date().getTime(), dataGenerator.getRundomString(dataGenerator.getRandomNumber(
                        addEnvironmentPage.getDescriptionMaxLenght()/2,
                        addEnvironmentPage.getDescriptionMaxLenght())));
        environmentsPage = addEnvironmentPage.submitAddEnvironmentForm();

        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
    }

    @Test (dataProvider = "addEnvironmentDataProvider")
    public void successAddEnvironmentDataDrivenTest(String name, String description){
        addEnvironmentPage = addEnvironmentPage.fillAddEnvironmentForm(
                name + "_" + new Date().getTime(), description);
        environmentsPage = addEnvironmentPage.submitAddEnvironmentForm();

        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
    }

    @DataProvider(name ="addEnvironmentDataProvider")
    public Object[] [] dataProvider(){
        return new DataReader().readData("addEnvironmentData.csv");
    }

//    @DataProvider(name ="addEnvironmentDataProvider")
//    public Object [][] dataProvider(){
//        return new Object[][]
//                {
//                        {"abc", "description1"},
//                        {"def", "description2"},
//                        {"ghi", "description3"}
//                };
//    }


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
