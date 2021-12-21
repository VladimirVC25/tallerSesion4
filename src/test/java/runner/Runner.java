package runner;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import session.Session;

import java.net.MalformedURLException;


@RunWith(Cucumber.class)
public class Runner {

    @Before
    public void beforeHook(){
        System.out.println("HOOK Before de cucumber");
    }

    @After
    public void afterHook(Scenario scenario) throws MalformedURLException {

        if (scenario.isFailed()){
            //take screenshot
            byte[] screenShot=Session.getSession().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png","screenshot failed image");
        }

        System.out.println("HOOK After de cucumber");
        Session.getSession().closeSession();
    }


}
