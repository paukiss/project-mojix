package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CRUDProjectTest extends TestBase{
    @Test
    public void test() {
        String nameProject = "nuevo project sergio";
        String updateNameProject = "update name project";

        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(user);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.projectLabel.waitControlIsNotVisibleElement();
        Assertions.assertTrue(mainPage.projectLabel.isControlDisplayed(), "Error! Log in failed");

        projectsPage.newProject.click();
        projectsPage.addProject.click();
        projectsPage.nameProject.setText(nameProject);
        projectsPage.addNewProject.click();
        Assertions.assertTrue(projectsPage.nameProjectHeader.isControlDisplayed(), "Error! Project was not created");

        projectsPage.clickOnNameProject(nameProject);
        projectsPage.newNameProject.waitControlIsNotVisibleElement();
        projectsPage.newNameProject.cleanSetText(updateNameProject);
        projectsPage.saveProject.click();
        Assertions.assertTrue(optionsProjectPage.optionsProject.isControlDisplayed(), "Error! Project was not updated");

        optionsProjectPage.optionsProject.click();
        optionsProjectPage.deleteOption.click();
        optionsProjectPage.confirmDelete.click();
        Assertions.assertEquals(projectsPage.nameProjectHeader.getText(), "Inbox", "Error! Project was not deleted");
    }
}
