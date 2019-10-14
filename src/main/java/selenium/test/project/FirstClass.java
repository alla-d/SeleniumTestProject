package selenium.test.project;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstClass {

    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\workplace\\chromedriver_77.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://beta.demo.testarena.pl/");
        Assert.assertEquals(
                driver.getTitle(),
                "Kokpit - TestArena");
        driver.quit();
    }
}
