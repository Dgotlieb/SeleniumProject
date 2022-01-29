package PresentWindow;

import Builder.BasePage;
import Builder.Report;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PresentScreen extends BasePage {
    private static final String PAGEURL = "https://buyme.co.il/search?budget=3&category=204&region=9";
    private static final String WAITFORELEMENT = "ember1751";
    private static final String PIZZA = "ember1865";
    private static final String SCROLLDOWN = "arguments[0].scrollIntoView(true);";
    private static final String PIZZASELECT = "ember2034";
    private static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PresentChoice() throws Exception {
        try {
            getUrl();
            Report.test.log(Status.PASS, "Present Screen:" + "  " + "Details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Report.test.log(Status.FAIL, "Present Screen:" + "  " +"Some details are incorrect :( ");
            throw new Exception("Test Faild");
        }
    }

    private static void getUrl() throws Exception {

            String pageUrl = driver.getCurrentUrl();
            Assert.assertEquals(pageUrl, PAGEURL);
            Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(WAITFORELEMENT)));
            WebElement pizzzaa = driver.findElement(By.id(PIZZA));
            ((JavascriptExecutor) driver).executeScript(SCROLLDOWN, pizzzaa);

        Report.TakePicture();
            Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PIZZA))).click();
            Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PIZZASELECT))).click();

        }
        }

