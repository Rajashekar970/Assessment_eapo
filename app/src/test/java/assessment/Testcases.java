package assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.time.Duration;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases {
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void launchbrowser() {
        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Parameters({ "username", "password" })
    @Test(description = "Login")
    public void testcase1(String username, String password) throws InterruptedException {
        driver.get("https://client-auth-dev.fanfix.dev/login");
        Thread.sleep(3000);
        Login loginpage = new Login(driver);
        loginpage.login(username, password);
        Thread.sleep(3000);
    }

    @Parameters({ "username", "password", "PostCaption", "subamount", "nonsubamount" })
    @Test(description = "Add a Post")
    public void testcase2(String username, String password, String PostCaption, String subamount, String nonsubamount)
            throws InterruptedException {
        driver.get("https://client-auth-dev.fanfix.dev/login");
        Thread.sleep(3000);
        Login loginpage = new Login(driver);
        loginpage.login(username, password);
        Thread.sleep(3000);
        Dashboard dash = new Dashboard(driver);
        dash.PostbuttonDisplayed();
        dash.ClickAction();
        NewPost Addingpost = new NewPost(driver);
        Addingpost.postcaption(PostCaption);
        Addingpost.Addingmedia();
        Addingpost.PostAction(subamount, nonsubamount);
    }

    // @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
