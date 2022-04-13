// Page URL: https://docs.google.com/forms/d/e/1FAIpQLSeI8_vYyaJgM7SJM4Y9AWfLq-tglWZh6yt7bEXEOJr_L-hV1A/viewform?formkey=dGx0b1ZrTnoyZDgtYXItMWVBdVlQQWc6MQ

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@SuppressWarnings("FieldCanBeLocal")

public class WebForm1 extends PageObject {

    public WebForm1(WebDriver driver) {
        super(driver);
    }

    private final String ShortAnswer = "Yes";
    private final String LongAnswer = "I know what you did last summer...";
    private final String AnotherAnswer = "And another summer also...";

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private WebElement short_answer;

    @FindBy(xpath = "//textarea[@aria-label='Twoja odpowiedź']")
    private WebElement long_answer;

    @FindBy(css = "div[class='RWzxl yqQS1 SjlgO'] input[aria-label='Inna odpowiedź']")
    private WebElement fill_another;

    @FindBy(xpath = "//div[@id='i27']//div[@class='uHMk6b fsHoPb']")
    private WebElement check_choice1;
    @FindBy(xpath = "//div[@id='i30']//div[@class='uHMk6b fsHoPb']")
    private WebElement check_choice2;

    @FindBy(css = "div[class='uArJ5e UQuaGc Y5sE8d VkkpIf NqnGTe'] span[class='l4V7wb Fxmcue']")
    private WebElement send_button;

    @FindBy(css = ".vHW8K")
    private WebElement check_sending;

    public void enterShortAnswer(){
        this.short_answer.sendKeys(ShortAnswer);
    }

    public void enterLongAnswer(){
        this.long_answer.sendKeys(LongAnswer);
    }

    public void fillAnotherChoice(){
        this.fill_another.sendKeys(AnotherAnswer);
    }

    public void checkChoices(){
        this.check_choice1.click();
        this.check_choice2.click();
    }

    public void pressSendButton(){
        this.send_button.click();
    }

    public void checkSending() {
        String actual = this.check_sending.getText().trim();
        String expected = "Your confirmation will show up on the screen after form is submitted";
        Assert.assertEquals(actual, expected);
//        System.out.println(actual);   //  Only to check what getText returns for string actual
    }

}

