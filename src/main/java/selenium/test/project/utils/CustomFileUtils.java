package selenium.test.project.utils;

import java.io.File;
import java.nio.file.Paths;

public class CustomFileUtils {

    public String getResourceFilePath(String file) {
        return Paths.get(
                new File(
                    getClass()
                        .getClassLoader()
                        .getResource(file)
                        .getFile())
                .getAbsolutePath()).toString();
    }
}
