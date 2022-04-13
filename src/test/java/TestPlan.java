import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
//         ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.ChromedriverLocation);
    }

    @AfterSuite
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Test(testName = "Test 1: Submit a WebForm")
    public static void submitForm() {
        driver.get(Utils.BaseURL);
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.enterJobTitle();
        webForm.markEducationLevel();
        webForm.checkSex();
        webForm.dropExperience();
        webForm.enterDate();
        webForm.pressSubmitButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-success")));
        webForm.checkSubmission();
    }

    @Test(testName = "Test 2: Submit a GoogleForm")
    public static void submitGoogleForm() {
        driver.get(Utils.BaseURL1);
        WebForm1 webForm1 = new WebForm1(driver);
        webForm1.enterShortAnswer();
        webForm1.enterLongAnswer();
        webForm1.fillAnotherChoice();
        webForm1.checkChoices();
        webForm1.pressSendButton();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".vHW8K")));    //  This test works without waiting for expected conditions, but it's here just in case
        webForm1.checkSending();
    }


}