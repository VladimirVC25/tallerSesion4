package runner;

import activity.MainScreen;
import activity.CreateTaskScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.util.Map;

public class WhenDoDefinition {
    MainScreen mainScreen = new MainScreen();
    CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    @Given("i have the whenDo app opened")
    public void iHaveTheWhenDoAppOpened() {
    }

    @And("i create an item using")
    public void iCreateAnItemUsing(Map<String,String> tasksValues) throws MalformedURLException {
        mainScreen.addTask.click();
        createTaskScreen.titleTextBox.typeText(tasksValues.get("title"));
        createTaskScreen.noteTextBox.typeText(tasksValues.get("note"));
        createTaskScreen.saveButton.click();
    }

    @Then("the item {string} should be displayed")
    public void theItemShouldBeDisplayed(String expectedResult) throws MalformedURLException {
        String actualResult=mainScreen.firstTak.getValue();
        Assertions.assertEquals(expectedResult,actualResult,"NO se creo la tarea");
    }
}
