package factoryDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCloud implements  IDevice{
    @Override
    public AppiumDriver create() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserstack.user", "vladimirvc_EmfYxp");
        caps.setCapability("browserstack.key", "YUFsktyfMfPcpzWLt6aM");

        caps.setCapability("app", "bs://6a6e5551362787b06d7f13fa47c3800fe1cc3410");

        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
        return driver;

    }
}
