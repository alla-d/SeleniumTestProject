package selenium.test.project.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileUtils {

    public String getResourceFilePathString(String file) {
    return getResourceFilePath(file).toString();
    }

    public Path getResourceFilePath(String file){
        return Paths.get(
                new File(
                        getClass()
                                .getClassLoader()
                                .getResource(file)
                                .getFile())
                        .getAbsolutePath());
    }

    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }
}
