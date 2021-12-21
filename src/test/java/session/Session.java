package session;

import control.ControlAppium;
import factoryDevice.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class Session {
    private static Session session = null;
    private AppiumDriver driver;

    private Session() throws MalformedURLException {
        driver= FactoryDevices.make(FactoryDevices.DeviceType.CLOUD).create();
    }

    public static Session getSession() throws MalformedURLException {
        if (session == null){
            session = new Session();
        }
        return session;
    }

    public void closeSession(){
        driver.quit();
        session=null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

}
