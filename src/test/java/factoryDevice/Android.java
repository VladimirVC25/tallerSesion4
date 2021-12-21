package factoryDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android implements IDevice{
    @Override
    public AppiumDriver create() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Redmi 10");
        capabilities.setCapability("appium:platformVersion","11");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}

