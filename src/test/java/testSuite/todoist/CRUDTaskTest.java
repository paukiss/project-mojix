package testSuite.todoist;

import control.Button;
import control.TextArea;
import control.TextBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CRUDTaskTest extends TestBase{
    @Test
    public void test(){
        String projectName = "project Sergio task3";
        String newTaskName = "Task 1";
        String newTaskDescription = "This task is about bootcamp QA";
        String updateTaskName = "Update task";
        String updateDescriptionTask = "Update task of QA";

        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(user);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.projectLabel.waitControlIsNotVisibleElement();
        Assertions.assertTrue(mainPage.projectLabel.isControlDisplayed(), "Error! Log in failed");

        projectsPage.newProject.click();
        projectsPage.selectNameProjectToAddTask(projectName);
        Assertions.assertTrue(projectPageTask.plusAddTask.isControlDisplayed(), "Error! The project doesnt exist");

        projectPageTask.plusAddTask.click();
        projectPageTask.taskName.setText(newTaskName);
        projectPageTask.description.setText(newTaskDescription);
        projectPageTask.addTask.click();
        Assertions.assertTrue(editTask.taskNameList.isControlDisplayed(), "Error! The task was not created");

        editTask.taskNameList.click();
        editTask.nameTaskActivate.click();
        editTask.nameTask.waitControlIsNotVisibleElement();
        editTask.nameTask.setText(updateTaskName);
        editTask.descriptionTask.cleanSetText(updateDescriptionTask);
        editTask.saveTask.click();
        Assertions.assertTrue(optionsTask.optionsTask.isControlDisplayed(), "Error! The task was not updated");

        optionsTask.optionsTask.click();
        optionsTask.deleteTask.click();
        optionsTask.confirmDeleteTask.click();
        Assertions.assertTrue(projectPageTask.plusAddTask.isControlDisplayed(), "Error! The task was not deleted");
    }
}
