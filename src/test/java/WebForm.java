// Page URL: https://formy-project.herokuapp.com/form

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

@SuppressWarnings("FieldCanBeLocal")

public class WebForm extends PageObject {

    public WebForm(WebDriver driver) {
        super(driver);
    }

    private final String firstName = "John";
    private final String lastName = "Howard";
    private final String jobTitle = "Carpenter";
    private final String dateForm = "01/16/1948";

    @FindBy(id = "first-name")
    private WebElement findFirstName;

    @FindBy(id = "last-name")
    private WebElement findLastName;

    @FindBy(id = "job-title")
    private WebElement findJobTitle;

    @FindBy(id = "radio-button-3")
    private WebElement findEducationLevel;

    @FindBy(id = "checkbox-3")
    private WebElement findSexCheckbox;

    @FindBy(id = "datepicker")
    private WebElement findDateForm;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement findSubmitButton;

    @FindBy(className = "alert-success")
    private WebElement findSubmission;

    public void enterFirstName(){
        this.findFirstName.sendKeys(firstName);
    }

    public void enterLastName(){
        this.findLastName.sendKeys(lastName);
    }

    public void enterJobTitle(){
        this.findJobTitle.sendKeys(jobTitle);
    }

    public void markEducationLevel(){
        this.findEducationLevel.click();
    }

    public void checkSex(){
        this.findSexCheckbox.click();
    }

    public void dropExperience(){
        Select dropExp = new Select(driver.findElement(By.id("select-menu")));
        dropExp.selectByValue("4");
    }

    public void enterDate(){
        this.findDateForm.sendKeys(dateForm);
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public void pressSubmitButton(){
        this.findSubmitButton.click();
    }

    public void checkSubmission() {
        String actual = this.findSubmission.getText().trim();
        String expected = "The form was successfully submitted!";
        Assert.assertEquals(actual, expected, "The form has errors");
    }
}