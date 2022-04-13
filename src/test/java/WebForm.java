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

    private final String FirstName = "John";
    private final String LastName = "Howard";
    private final String JobTitle = "Carpenter";
    private final String DateForm = "01/16/1948";

    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(id = "job-title")
    private WebElement job_title;

    @FindBy(id = "radio-button-3")
    private WebElement education_level;

    @FindBy(id = "checkbox-3")
    private WebElement sex_checkbox;

    @FindBy(id = "datepicker")
    private WebElement date_form;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement submit_button;

    @FindBy(className = "alert-success")
    private WebElement check_submission;

    public void enterFirstName(){
        this.first_name.sendKeys(FirstName);
    }

    public void enterLastName(){
        this.last_name.sendKeys(LastName);
    }

    public void enterJobTitle(){
        this.job_title.sendKeys(JobTitle);
    }

    public void markEducationLevel(){
        this.education_level.click();
    }

    public void checkSex(){
        this.sex_checkbox.click();
    }

    public void dropExperience(){
        Select dropExp = new Select(driver.findElement(By.id("select-menu")));
        dropExp.selectByValue("4");
    }

    public void enterDate(){
        this.date_form.sendKeys(DateForm);
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void checkSubmission() {
        String actual = this.check_submission.getText().trim();
        String expected = "The form was successfully submitted!";
        Assert.assertEquals(actual, expected, "The form has errors");
    }
}