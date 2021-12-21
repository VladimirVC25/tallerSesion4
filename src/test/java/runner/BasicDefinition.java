package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicDefinition {

    private AppiumDriver driver;

    @Given("la aplicacion WhenDo esta abierta")
    public void laAplicacionWhenDoEstaAbierta() throws MalformedURLException {
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

    @When("presiono el boton +")
    public void presionoElBoton() {
        //Pulsar sobre agregar
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='2']")).click();
    }

    @And("agregar titulo {string}")
    public void agregarTitulo(String texto) {
        //Agregar Titulo
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(texto);
    }

    @And("agregar notas  {string}")
    public void agregarNotas(String texto) {
        //Agregar Notas
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(texto);
    }

    @And("presiono confirmar")
    public void presionoConfirmar() {
        //Pulsar e confirmar
        driver.findElementByAccessibilityId("Guardar").click();
    }

    @Then("el resultado deberia ser: {string}")
    public void elResultadoDeberiaSer(String texto) {
        String actualResult1=driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        String expectedResult1=texto;
        Assertions.assertEquals(expectedResult1,actualResult1,"ERROR! tarea no encontrada");
    }


}
