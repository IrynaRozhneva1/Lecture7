package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Iryna_Rozhneva
 */
public class StartPage {

    @FindBy(xpath = "//a[contains(@class,'link') and text()='�����']")
    private WebElement buttonEmailToOpenSignInPage;

    public static final String BASE_URL = "https://yandex.ru";
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
        System.out.println("Yandex is opened");
    }

    public SignInPage invokeSignIn() {
    	buttonEmailToOpenSignInPage.click();
    	System.out.println("Open login form");
        return new SignInPage(driver);
    }
}
