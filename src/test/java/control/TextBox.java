package control;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends ControlAppium{
    public TextBox(By locator) {
        super(locator);
    }

    public void typeText(String value) throws MalformedURLException {
        this.findControl();
        this.control.sendKeys(value);
    }

}
