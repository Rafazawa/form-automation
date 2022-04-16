// Page URL: https://docs.google.com/forms/d/e/1FAIpQLSeI8_vYyaJgM7SJM4Y9AWfLq-tglWZh6yt7bEXEOJr_L-hV1A/viewform?formkey=dGx0b1ZrTnoyZDgtYXItMWVBdVlQQWc6MQ

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@SuppressWarnings("FieldCanBeLocal")

public class WebForm1 extends PageObject {

    public WebForm1(WebDriver driver) {
        super(driver);
    }

    private final String shortAnswer = "Yes";
    private final String longAnswer = "I know what you did last summer...";
    private final String anotherAnswer = "And another summer also...";

    @FindBy(xpath = "//input[@class='whsOnd zHQkBf']")
    private WebElement findShortAnswer;

    @FindBy(xpath = "//textarea[@aria-label='Twoja odpowiedź']")
    private WebElement findLongAnswer;

    @FindBy(css = "div[class='RWzxl yqQS1 SjlgO'] input[aria-label='Inna odpowiedź']")
    private WebElement findAnotherAnswer;

    @FindBy(xpath = "//div[@id='i27']//div[@class='uHMk6b fsHoPb']")
    private WebElement findChoice1;
    @FindBy(xpath = "//div[@id='i30']//div[@class='uHMk6b fsHoPb']")
    private WebElement findChoice2;

    @FindBy(xpath = "//div[@class='uArJ5e UQuaGc Y5sE8d VkkpIf QvWxOd']//span[@class='l4V7wb Fxmcue']")
    private WebElement findSendButton;

    @FindBy(css = ".vHW8K")
    private WebElement findSending;

    public void enterShortAnswer(){
        this.findShortAnswer.sendKeys(shortAnswer);
    }

    public void enterLongAnswer(){
        this.findLongAnswer.sendKeys(longAnswer);
    }

    public void fillAnotherChoice(){
        this.findAnotherAnswer.sendKeys(anotherAnswer);
    }

    public void checkChoices(){
        this.findChoice1.click();
        this.findChoice2.click();
    }

    public void pressSendButton(){
        this.findSendButton.click();
    }

    public void checkSending() {
        String actual = this.findSending.getText().trim();
        String expected = "Your confirmation will show up on the screen after form is submitted";
        Assert.assertEquals(actual, expected);
//        System.out.println(actual);   //  Only to check what getText returns for string actual
    }

}

