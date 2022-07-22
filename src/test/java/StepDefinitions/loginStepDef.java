package StepDefinitions;

import Pages.LoginPage;
import Utilities.General;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginStepDef extends Base{

    @Before
    public void setup(){
        //for MAC OS
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/Drivers/chromedriver");
        //for Windows
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hudl.com/");
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Given("User launch browser and open Hudl main page")
    public void userLaunchBrowserAndOpenHudlMainPage() {
        loginPage = new LoginPage(driver);
        general = new General(driver);
    }

    @And("User clicks Login button link")
    public void userClicksLoginButtonLink() {
        general.clickButton(loginPage.loginLink);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/login");
    }

    @And("User enters Email as {string} and Password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String password) {
        general.enterText(loginPage.emailInput, email);
        general.enterEncryptedText(loginPage.passwordInput, password);
    }

    @When("User clicks Login button")
    public void userClicksLoginButton()  {
        general.clickButton(loginPage.logInButton);
    }

    @Then("User see home page")
    public void userSeeHomePage() {
        general.waitForElementToBeVisible(loginPage.userName);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/home");
        Assert.assertEquals(general.getTitleName(), "Home - Hudl");
    }

    @And("User see first name {string} and email {string}")
    public void userSeeFirstNameAndEmail(String firstName, String email) {
        Assert.assertEquals(general.getElementText(loginPage.userName), firstName);
        general.hoverOverElement(loginPage.userMenuDropdown);
        general.waitForElementToBeVisible(loginPage.emailLocator);
        Assert.assertEquals(general.getElementText(loginPage.emailLocator), email);
    }

    @Then("User see error message")
    public void userSeeErrorMessage() {
        general.waitForElementToBeVisible(loginPage.error);
        general.verifyElementIsDisplayed(loginPage.logInError);
    }

    @When("User click Sign up link")
    public void userClickSignUpLink() {
        general.clickButton(loginPage.signUpLink);
    }

    @Then("User landed in Sign up page")
    public void userLandedInSignUpPage() {
        general.waitForElementToBeVisible(loginPage.signUpHeader);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/register/signup");
        Assert.assertEquals(general.getElementText(loginPage.signUpHeader), "Request a Free Demo");
    }

    @Given("User encodes {string} string")
    public void userEncodesString(String text) {
        general.enterEncryptedText(loginPage.passwordInput,text);
    }

    @When("User clicks Log In With an Organization")
    public void userClicksLogInWithAnOrganization() {
        general.clickButton(loginPage.logInWithAnOrganization);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/app/auth/login/organization");
    }

    @And("User clicks Log In With Email and Password button")
    public void userClicksLogInWithEmailAndPasswordButton() {
        general.clickButton(loginPage.logInWithEmailAndPass);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/login");
    }

    @And("User clicks Need help button")
    public void userClicksNeedHelpButton() {
        general.clickButton(loginPage.needHelpLink);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/login/help#");
        Assert.assertEquals(general.getElementText(loginPage.loginHelpHeader), "Login Help");
    }

    @And("User enters email {string}")
    public void userEntersPassword(String email) {
        general.enterText(loginPage.passResetEmailInput, email);
    }

    @And("User clicks Send Password Button")
    public void userClicksSendPasswordButton() {
        general.clickButton(loginPage.passResetButton);
    }

    @Then("User see Check Your Email page")
    public void userSeeCheckYourEmailPage() {
        general.waitForElementToBeVisible(loginPage.checkYourEmailContainer);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/login/check-email");
        Assert.assertEquals(general.getElementText(loginPage.checkYourEmailText), "Check Your Email\n" +
                "Click the link in the email to reset your password.\n" +
                "If you don't see the email, check your junk or spam folders.");
    }

    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

    @Then("User see password reset error message {string}")
    public void userSeePasswordResetErrorMessage(String text) {
        general.waitForElementToBeVisible(loginPage.passResetError);
        Assert.assertEquals(general.getElementText(loginPage.passResetError), text);
    }

    @When("User clicks Hudl logo")
    public void userClicksHudlIcon() {
        general.clickButton(loginPage.hudlLogo);
    }

    @Then("User verifies home page is open")
    public void userVerifiesHomePageIsOpen() {
        general.waitForElementToBeVisible(loginPage.loginLink);
        Assert.assertEquals(general.getUrl(), "https://www.hudl.com/");
        Assert.assertEquals(general.getTitleName(), "Hudl: We Help Teams and Athletes Win");
    }
}

