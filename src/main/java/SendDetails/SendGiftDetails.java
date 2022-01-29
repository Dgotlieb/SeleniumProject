package SendDetails;

import Builder.BasePage;
import Builder.Report;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SendGiftDetails extends BasePage {
    private static final String NAME = "ember2152";
    private static final String THISNAME = "בוב הבנאי";
    private static final String FORWHATEVENT = "ember2212";
    private static final String INSULATION = "ember2247";
    private static final String CLEARFIELD = "textarea-clear-all";
    private static final String BLESSING = "parsley-success";
    private static final String THISBLESSING = "עידוד לבידוד יא תחת ;) ";
    private static final String UPLOADFILE = "ember2172";
    private static final String FILEPATH = "C:\\Users\\User\\IdeaProjects\\Project\\src\\main\\java\\best-ny-pizza.jpg";
    private static final String PROCEDTOPAYMENT  = "ember2173";
    private static final String PICKEMAIL = "#ember2296 > div:nth-child(2) > div.circle-area > svg";
    private static final String SENDKEYSEMAIL = "email";
    private static final String  WHATEMAIL = "BobTheBuilder@gmail.com";
    private static final String SENDERNAMEELEMENT = "ember2316";
    private static final String SENDERNAME = "MARCO ROSSI";
    private static final String ENDPROJECTCLICK = "ember2321";

    public static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendAGift() throws Exception {
        try {


            FillDetails();
            UploadFile();
            ClickProceedButton();
            SenderDetails();
            Report.test.log(Status.PASS , "Send Gift Screen:"+ "  "+"Details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Report.test.log(Status.FAIL, "Send Gift Screen:"+ "  "+"Some details are incorrect :( ");
            throw new Exception("Test Faild");
        }
    }


    private static void FillDetails(){

        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NAME))).sendKeys(THISNAME);
        Assert.assertEquals(driver.findElement(By.id(NAME)).getAttribute("value"), THISNAME);
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(FORWHATEVENT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(INSULATION))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.className(CLEARFIELD))).click();
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(BLESSING))).sendKeys( THISBLESSING);
    }
    private static void UploadFile() throws Exception {


        WebElement fileUpload = driver.findElement(By.id(UPLOADFILE));
        fileUpload.sendKeys(FILEPATH);
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gift-step-1 > div.grid.pin-end.no-gap.top-xl > div.mx-12.top-md > div.grid.no-gap.bm-media-section > div.mx-auto.top-lr.bm-media-upload-thumbnail > div")));
      Report.TakePicture();

    }
    private static void ClickProceedButton(){
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PROCEDTOPAYMENT))).click();

    }
    private static void SenderDetails() throws Exception {
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PICKEMAIL))).click();
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SENDKEYSEMAIL))).sendKeys(WHATEMAIL);
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SENDERNAMEELEMENT))).sendKeys(SENDERNAME);
        Assert.assertEquals(driver.findElement(By.id(SENDERNAMEELEMENT) ).getAttribute("value") , SENDERNAME);

        Report.TakePicture();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(ENDPROJECTCLICK))).click();





    }
}
