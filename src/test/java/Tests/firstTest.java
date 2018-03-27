package Tests;

import common.optiimng;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

public class firstTest extends optiimng {

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        dc.setCapability("app", "/Users/huseyintumer/appiumstudio/original-apks/com.experitest.ExperiBank.LoginActivity.2.apk");
        AndroidTest(udid);
    }

    @Test
    public void testUntitled() {

        findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        findElement(By.id("com.experitest.ExperiBank:id/mortageRequestButton")).click();
        findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("huseyin");
        findElement(By.id("com.experitest.ExperiBank:id/lastNameTextField")).sendKeys("tumer");

    }

    @AfterClass
    public void tearDown() {
        finishAndroidTest();
    }
}

