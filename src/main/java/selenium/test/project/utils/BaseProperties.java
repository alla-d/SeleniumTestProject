package selenium.test.project.utils;

public class BaseProperties {

    public static String ADMIN_EMAIL = "administrator@testarena.pl";
    public static String ADMIN_PASSWORD ="sumXQQ72$L";

    public static String BASE_URL ="http://beta.demo.testarena.pl/";

    public static String CHROME_DRIVER = "chromedriver_77.exe";
    public static String FIREFOX_DRIVER = "geckodriver_026.exe";

    public static long IMPLISITLY_WAIT_SECOND = 5;
    public static boolean WINDOW_MAXIMAZE = true;

    public static String LOG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";

    public static String SCREENSHOTS_DIRECTORY= "/screenshots/";

    public static String[] TEST_RESULT_NAME = new String[]{
            "UNKNOWN",
            "PASS",
            "FAIL",
            "SKIP"
    };

    public static String REPORT_DIRECTORY = "/reports/";
    public static String REPORT_NAME = "testReport.html";
}
