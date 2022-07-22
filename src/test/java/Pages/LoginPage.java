package Pages;

import Utilities.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    General general;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        general = new General(driver);
    }

    //locators
    public final By loginLink                = By.xpath("//a[@data-qa-id = 'login']");
    public final By emailInput               = By.xpath("//input[@data-qa-id = 'email-input']");
    public final By emailLocator             = By.cssSelector(".hui-globaluseritem__email");
    public final By error                    = By.xpath("//p[@data-qa-id = 'error-display']");
    public final By passwordInput            = By.xpath("//input[@data-qa-id = 'password-input']");
    public final By logInButton              = By.xpath("//button[@data-qa-id = 'login-btn']");
    public final By needHelpLink             = By.xpath("//a[@data-qa-id = 'need-help-link']");
    public final By signUpLink               = By.xpath("//*[@id = 'app']/section/div[2]/a");
    public final By logInWithAnOrganization  = By.xpath("//button[@data-qa-id = 'log-in-with-organization-btn']");
    public final By logInWithEmailAndPass    = By.xpath("//button[@data-qa-id = 'log-in-with-email-and-password']");
    public final By userMenuDropdown         = By.cssSelector("div.hui-globalusermenu");
    public final By userName                 = By.cssSelector("div.hui-globaluseritem__display-name");
    public final By logInError               = By.xpath("//p[@data-qa-id = 'error-display']");
    public final By signUpHeader             = By.xpath("//h1");
    public final By passResetEmailInput      = By.xpath("//input[@data-qa-id = 'password-reset-input']");
    public final By passResetButton          = By.xpath("//button[@data-qa-id = 'password-reset-submit-btn']");
    public final By loginHelpHeader          = By.xpath("//h2[@data-qa-id = 'login-help-headline']");
    public final By checkYourEmailContainer  = By.cssSelector("div.styles_checkEmailContainer_dCcIQgewcgLBpVg3jlAGd");
    public final By checkYourEmailText       = By.cssSelector("div.uni-form--large");
    public final By passResetError           = By.xpath("//p[@data-qa-id = 'password-reset-error-display']");
    public final By hudlLogo                 = By.xpath("//*[@data-qa-id = 'hudl-logo']/..");

    //methods
}
