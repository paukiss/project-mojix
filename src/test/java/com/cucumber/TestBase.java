package com.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ticktick.*;
import session.Session;
import util.GetProperties;

public class TestBase {

    LoginSession loginSession = new LoginSession();
    LoginPageSession loginPageSession = new LoginPageSession();
    MainPage mainPage = new MainPage();
    CreateTaskList createTaskList = new CreateTaskList();
    AddList addList = new AddList();
    OptionTaskList optionTaskList = new OptionTaskList();
    TaskList taskList = new TaskList();
    DeleteList deleteList = new DeleteList();
    EditList editList = new EditList();
    String user = GetProperties.getInstance().getUser();
    String pass = GetProperties.getInstance().getPass();

    String newTaskName;
    String updateTaskName = "Update task";

    @Given("Load page ticktick")
    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @Given("Close the session")
    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }

    @When("User log in")
    public void logginUser() {
        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(user);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.inboxLabel.waitControlIsNotVisibleElement();
    }

    @And("Verify user logged in the page")
    public void userLoggedInThePage() {
        Assertions.assertTrue(mainPage.inboxLabel.isControlDisplayed(), "Error! Log in failed");
    }

    @When("User create a new task")
    public void createTask() {
        createTaskList.buttonPlusAddList.click();
        addList.titleAddList.waitControlIsNotVisibleElement();
    }
    @Then("The task is named {string}")
    public void theTaskIsNamed(String task) throws InterruptedException {
        newTaskName = task;
        addList.nameTaskList.setText(newTaskName);
        addList.saveList.click();
        taskList.labelTask(newTaskName).waitControlIsNotVisibleElement();
        taskList.labelTask(newTaskName).click();
        optionTaskList.buttonDots(newTaskName).waitControlIsNotVisibleElement();
        Thread.sleep(2000);
        optionTaskList.buttonDots(newTaskName).click();
        optionTaskList.textEdit.click();
    }
    @And("Verify the task was created")
    public void verifyTheTaskWasCreated() {
        Assertions.assertTrue(editList.editTextBox.isControlDisplayed(), "Error! Task was not created");
    }
    @When("User update the task with {string}")
    public void updateTask(String newName) {
        updateTaskName = newName;
        editList.editTextBox.setText(updateTaskName);
        editList.saveEditText.click();
        taskList.labelTask(newTaskName + updateTaskName).waitControlIsNotVisibleElement();
    }
    @And("Verify the task was updated")
    public void verifyTheTaskWasUpdated() {
        Assertions.assertTrue(taskList.labelTask(newTaskName + updateTaskName).isControlDisplayed(), "Error! Task was not updated");
    }
    @When("User delete the task")
    public void deleteTask() {
        optionTaskList.buttonDots(newTaskName+updateTaskName).click();
        optionTaskList.textDelete.isControlDisplayed();
        optionTaskList.textDelete.click();
        deleteList.deleteConfirm.waitControlIsNotVisibleElement();
        deleteList.deleteConfirm.click();
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
    @And("Verify the task was delete")
    public void verifyTheTaskWasDelete() {
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
}
