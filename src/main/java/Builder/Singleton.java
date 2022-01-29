package Builder;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class Singleton {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriverInstance() throws Exception {

        if (driver == null) {
            Report.beforeClass();

            try {

                System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                wait = new WebDriverWait(Singleton.getDriverInstance(), Duration.ofSeconds(10));
                Report.test.log(Status.PASS, "Driver established successfully");
                driver.get("https://buyme.co.il/");
                driver.manage().window().maximize();

            } catch (Exception e) {
                e.printStackTrace();
                Report.test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
                throw new Exception("Driver failed");
            }

        }
        return driver;
    }

}



