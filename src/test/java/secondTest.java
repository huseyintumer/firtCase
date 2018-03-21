import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

public class secondTest extends optiimng {

    EventFiringWebDriver eventDriver;

    @Parameters({"udid"})
    @BeforeClass
    public void setUp(String udid) {
        IOSTest(udid);
        dc.setCapability("bundleId", "com.experitest.ExperiBank");
        dc.setCapability("xcodeOrgId", "29PDGXQ299");
        dc.setCapability("xcodeSigningId", "iPhone Developer");
        iOSDriver = new IOSDriver<WebElement>(service, dc);
        eventDriver = new EventFiringWebDriver(iOSDriver);
        eventDriver.register(handler);
    }

    @Test
    public void testUntitled() {

        WebElement el1 = eventDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"usernameTextField\"])[1]"));
        el1.sendKeys("company");
        WebElement el2 = eventDriver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"passwordTextField\"])[1]"));
        el2.sendKeys("company");
        WebElement el3 = eventDriver.findElement(By.id("loginButton"));
        el3.click();
        WebElement el4 = eventDriver.findElement(By.id("makePaymentButton"));
        el4.click();
        WebElement el5 = eventDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"nameTextField\"])[1]"));
        el5.sendKeys("cacaca");

    }

    @AfterClass
    public void tearDown() {
        if (iOSDriver != null) {
            iOSDriver.quit();
            eventDriver.quit();
        }
        if (this.service.isRunning()) {
            service.stop();
        }
    }
}

