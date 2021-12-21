package control;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.net.MalformedURLException;

public class ControlAppium {
       protected WebElement control;
       protected By locator;

       public ControlAppium (By locator){
              this.locator=locator;
       }

       protected void findControl() throws MalformedURLException {
              this.control= Session.getSession().getDriver().findElement(this.locator);
       }

       public void click() throws MalformedURLException {
              this.findControl();
              this.control.click();
       }

       public String getValue() throws MalformedURLException {
              this.findControl();
              return this.control.getText();
       }

       public boolean isDisplayedControl() {
              try {
                     this.findControl();
                     return this.control.isDisplayed();
              }catch (Exception e){
                     return false;
              }
       }

       public WebElement getControl() throws MalformedURLException {
              this.findControl();
              return control;
       }
}
