package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
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
    public void enterValidEmailAndInvalidPassword(DataTable table){
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(1).get("password");
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    @Then("Alert appeared")
    public void isAlertAppeared(){
        Assert.assertTrue(isAlertPresent());
    }

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

    private boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
        }
        return true;
    }
}
