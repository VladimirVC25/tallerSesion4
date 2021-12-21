package BasicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicList {
    private AppiumDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Redmi 10");
        capabilities.setCapability("appium:platformVersion","11");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void after() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void createContact(){

        String T1="Tarea 1";
        String T2="Tarea 2";
        String N1="Nota 1";
        String N2="Nota 2";

        //Pulsar sobre agregar
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='2']")).click();
        //Agregar Titulo
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(T1);
        //Agregar Notas
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(N1);
        //Pulsar e confirmar, sin regresar a la pantalla 1
        driver.findElementByAccessibilityId("Guardar y Nuevo").click();

        //Agregar Titulo 2
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(T2);
        //Agregar Notas 2
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(N2);
        //Pulsar e confirmar
        driver.findElementByAccessibilityId("Guardar").click();

        String actualResult1=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        String expectedResult1=T1;
        Assertions.assertEquals(expectedResult1,actualResult1,"ERROR! tarea no encontrada");
    }
}
