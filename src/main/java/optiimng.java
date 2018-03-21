import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class optiimng {

    public AndroidDriver<WebElement> androidDriver = null;
    public IOSDriver<WebElement> iOSDriver = null;

    public AppiumDriverLocalService service;
    public DesiredCapabilities dc = new DesiredCapabilities();

    OptiimDriverListener handler = new OptiimDriverListener();

    public AppiumDriverLocalService createAppiumService() {
        AppiumDriverLocalService service;
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .usingAnyFreePort();
        service = builder.build();
        return service;
    }

    public void IOSTest(String udid) {
        service = createAppiumService();
        dc.setCapability("deviceName", "iOS");
        dc.setCapability("udid", udid);
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("platformVersion", "11.2");
    }

    public void AndroidTest(String udid) {

        service = createAppiumService();
        dc.setCapability("deviceName", "Android");
        dc.setCapability("udid", udid);

    }

}
