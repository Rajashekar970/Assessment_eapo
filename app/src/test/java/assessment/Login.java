package assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input css-bq7kn6' and @name='email']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement button;

    public void login(String Username, String Password) throws InterruptedException {
        username.sendKeys(Username);
        pass.sendKeys(Password);
        button.click();
        Thread.sleep(3000);
        System.out.println("Login Successful");

    }

}
