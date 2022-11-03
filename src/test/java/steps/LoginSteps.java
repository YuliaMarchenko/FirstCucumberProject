package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    @Given("Navigate to Home Page")
    public void navigateToHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app/contacts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("Click on Login tab")
    public void clickOnLoginTab(){
        click(By.xpath("//a[.='LOGIN']"));
    }

    @Then("Appear LoginRegistration form")
    public void isLoginRegistrationFormPresent(){
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
    }

    @And("Enter valid data")
    public void enterValidData(){
        type(By.xpath("//input[@placeholder='Email']"), "test102@test.com");
        type(By.xpath("//input[@placeholder='Password']"), "test12_TEST");
    }

    @And("Click on login Button")
    public void clickOnLoginButton(){
        click(By.xpath("//button[.=' Login']"));
    }

    @Then("SingOut button displayed")
    public void isSingOutButtonPresent(){
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @And("Enter valid email and invalid password")
    public void enterValidEmailAndInvalidPassword(){

    }

    @Then("Alert appeared")
    public void isAlertPresent(){}

    private void click(By locator){
        driver.findElement(locator).click();
    }

    private boolean isElementPresent(By locator){
        return  driver.findElements(locator).size() > 0;
    }

    private void type(By locator, String text){
        if (text != null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }
}
