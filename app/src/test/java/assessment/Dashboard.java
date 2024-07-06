package assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver driver;

    @FindBy(xpath = "//button[text()='New Post']")
    WebElement Postbutton;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean PostbuttonDisplayed() {
        Postbutton.isDisplayed();
        return true;
    }

    public void ClickAction() throws InterruptedException {
        Postbutton.click();
        Thread.sleep(3000);
    }

}
