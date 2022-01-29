import Builder.Report;
import Builder.Singleton;
import HomeScreen.HomeActions;
import PresentWindow.PresentScreen;
import SendDetails.SendGiftDetails;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Run {
    @BeforeClass
    public static void beforeAll() throws Exception {

        Singleton.getDriverInstance();


    }

   @Test
   public static void loginPage() throws Exception {
       Login loginPage = new Login();
       loginPage.login();


   }

    @Test
    public static void homeScreen() throws Exception {
        HomeActions choice = new HomeActions();
        choice.HomeChoice();


    }

    @Test
    public static void presentScreen() throws Exception {
        PresentScreen present = new PresentScreen();
        present.PresentChoice();
    }
@Test

        public static void sendDetails() throws Exception {
    SendGiftDetails sendGiftDetails = new SendGiftDetails();
    sendGiftDetails.SendAGift();

        }
@AfterClass
    public static void ProjectEnd() throws Exception {
    Report.extent.flush();
        Singleton.getDriverInstance().quit();

    }
    }

