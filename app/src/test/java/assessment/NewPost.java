package assessment;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPost {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public NewPost(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/textarea[@name='post-caption']")
    WebElement PostCaption;
    @FindBy(xpath = "//div/button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-bvx9sv']")
    WebElement plusicon;
    @FindBy(xpath = "//button[text()='Upload Media']")
    WebElement Uploadbutton;
    @FindBy(xpath = "//input[@type='file' and @name='file']")
    WebElement imagefile;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement Continuebutton;
    @FindBy(xpath = "//div[text()='Media uploaded successfully']")
    WebElement Uploadsuccessmessage;
    @FindBy(xpath = "(//div[@class='MuiBox-root css-cnbb3m'])[1]/img")
    WebElement Selectimage;
    @FindBy(xpath = "//button[text()='Add Media']")
    WebElement addmedia_button;
    @FindBy(xpath = "//p[text()='Subscriber Price']/../following-sibling::div//div/span/p[text()='Custom']")
    WebElement Subscriberprice_Custom;
    @FindBy(xpath = "//p[text()='Non-Subscriber Price']/../following-sibling::div//div/span/p[text()='Custom']")
    WebElement Nonsubsprice_Custom;
    @FindBy(xpath = "(//input[@name='custom-sub'])[1]")
    WebElement amount1;
    @FindBy(xpath = "(//input[@name='custom-sub'])[2]")
    WebElement amount2;
    @FindBy(xpath = "//button[text()='Post to Profile']")
    WebElement postbutton;
    @FindBy(xpath = "//div[text()='Post Created']")
    WebElement successmessage;

    public void postcaption(String message) {
        // Entering the text in Postcaption text field
        PostCaption.sendKeys(message);
    }

    public void Addingmedia() throws InterruptedException {
        String imagepath = "C:\\Users\\shekar\\OneDrive\\Pictures\\Screenshots\\test.png";
        plusicon.click();
        Thread.sleep(3000);
        // Clicking on Upload button
        Uploadbutton.click();
        Thread.sleep(3000);
        System.out.println("Clicked on upload button");
        Thread.sleep(2000);
        // Select the image from local path
        imagefile.sendKeys(imagepath);
        Thread.sleep(10000);
        Continuebutton.click();
        Thread.sleep(3000);
        boolean title = Uploadsuccessmessage.isDisplayed();
        System.out.println("Image Upload message :" + " " + title + " " + Uploadsuccessmessage.getText());
        Selectimage.click();
        // Click on Addmedia button
        addmedia_button.click();
        Thread.sleep(3000);
        Subscriberprice_Custom.click();
        Thread.sleep(3000);
        // amount1.click();
        Subscriberprice_Custom.click();
        amount1.sendKeys("2.00");
        double num = Double.parseDouble(amount1.getAttribute("value"));
        int i = (int) num;
        System.out.println(i);
        if (num < 5.00) {
            boolean status = !postbutton.isEnabled();
            System.out.println("Post button is disabled " + status);
        }

        Nonsubsprice_Custom.click();
        amount2.sendKeys("3.00");
        // amount2.click();
        Nonsubsprice_Custom.click();
        double num1 = Double.parseDouble(amount2.getAttribute("value"));
        int j = (int) num1;
        if (j < 5.0) {
            boolean status2 = !postbutton.isEnabled();
            System.out.println("Post button is disabled for less amount of 5 " + status2);
        }
    }

    public void PostAction(String subamount, String nonsubamount) throws InterruptedException {
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        amount1.sendKeys(Keys.chord(Keys.CONTROL,"a"),subamount);
        //jse.executeScript("arguments[0].value = '';", amount1);
        Thread.sleep(4000);
        System.out.println("After passing value in subscriber custom amount is " + amount1.getAttribute("value"));
        amount2.sendKeys(Keys.chord(Keys.CONTROL,"a"),nonsubamount);
        Thread.sleep(5000);
        System.out.println("After Entering value in Nonsubscriber Custom amount is " + amount2.getAttribute("value"));
        postbutton.click();
        Thread.sleep(3000);
        if (successmessage.isDisplayed()) {
            System.out.println("Successfully posted message - " + successmessage.getText());
        }
    }
}
