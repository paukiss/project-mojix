package testSuite.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

public class CRUDTaskTest extends TestBase {
    @Test
    public void test() {
        String newTaskName = "task123456";
        String updateTaskName = "Update task";

//        Loggin user
        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(user);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.inboxLabel.waitControlIsNotVisibleElement();
        Assertions.assertTrue(mainPage.inboxLabel.isControlDisplayed(), "Error! Log in failed");

//        Create Task
        createTaskList.buttonPlusAddList.click();
        addList.titleAddList.waitControlIsNotVisibleElement();
        addList.nameTaskList.setText(newTaskName);
        addList.saveList.click();
        taskList.labelTask(newTaskName).waitControlIsNotVisibleElement();
        taskList.labelTask(newTaskName).click();
        optionTaskList.buttonDots(newTaskName).waitControlIsNotVisibleElement();
        optionTaskList.buttonDots(newTaskName).click();
        optionTaskList.textEdit.click();
        Assertions.assertTrue(editList.editTextBox.isControlDisplayed(), "Error! Task was not created");

//        Update task
        editList.editTextBox.setText(updateTaskName);
        editList.saveEditText.click();
        taskList.labelTask(newTaskName+updateTaskName).waitControlIsNotVisibleElement();
        Assertions.assertTrue(taskList.labelTask(newTaskName+updateTaskName).isControlDisplayed(), "Error! Task was not updated");

//        Delete task
        optionTaskList.buttonDots(newTaskName+updateTaskName).click();
        optionTaskList.textDelete.isControlDisplayed();
        optionTaskList.textDelete.click();
        deleteList.deleteConfirm.waitControlIsNotVisibleElement();
        deleteList.deleteConfirm.click();
        Assertions.assertFalse(taskList.labelTask(updateTaskName).isControlDisplayed(), "Error! Task was not deleted");
    }
}
