import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

public class firstTest extends optiimng {

    EventFiringWebDriver eventDriver;

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        AndroidTest(udid);
        dc.setCapability("app", "/Users/huseyintumer/appiumstudio/original-apks/com.experitest.ExperiBank.LoginActivity.2.apk");
        androidDriver = new AndroidDriver<>(service, dc);
        eventDriver = new EventFiringWebDriver(androidDriver);
        eventDriver.register(handler);
    }

    @Test
    public void testUntitled() {

        WebElement el1 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField"));
        el1.sendKeys("company");
        WebElement el2 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField"));
        el2.sendKeys("company");
        WebElement el3 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/loginButton"));
        el3.click();
        WebElement el4 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/mortageRequestButton"));
        el4.click();
        WebElement el5 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField"));
        el5.sendKeys("huseyin");
        WebElement el6 = eventDriver.findElement(By.id("com.experitest.ExperiBank:id/lastNameTextField"));
        el6.sendKeys("tumer");

    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
        if (androidDriver != null) {
            androidDriver.quit();
            eventDriver.quit();
        }
        if (this.service.isRunning()) {
            service.stop();
        }
    }
}

