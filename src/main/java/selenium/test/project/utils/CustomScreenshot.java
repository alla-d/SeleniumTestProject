package selenium.test.project.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CustomScreenshot {

    public static String MAKE_SCREENSHOT_ALWAYS = "always";
    public static String MAKE_SCREENSHOT_FAIL = "fail";

    public String makeScreenshot(WebDriver driver, String name){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filePath = CustomFileUtils.getProjectPath() +
                BaseProperties.SCREENSHOTS_DIRECTORY +
                new Date().getTime() + "_"  + name + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
