package testSuite.todoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class CRUDProjectTest extends TestBase{

    @Test
    public void verifyCRUDProject(){
        String projectCreated="MOJIX"+new Date().getTime();
        String projectUpdate="QA"+new Date().getTime();

        mainPage.loginLabel.click();

        loginSession.emailTxtBox.setText(user);
        loginSession.passwordTxtBox.setText(pass);
        loginSession.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error! the login");

        projectSection.addNewProjectButton.click();
        projectSection.nameProjectTxtBox.setText(projectCreated);
        projectSection.addButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated), "Error! Project was not created");

        projectSection.clickOnProject(projectCreated);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.editButton.click();
        projectSection.editProjectTxtBox.cleanSetText(projectUpdate);
        projectSection.saveButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectUpdate), "Error! Project was not updated");

        projectSection.clickOnProject(projectUpdate);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.deleteButton.click();
        Session.getInstance().acceptAlert();
        projectSection.getProject(projectUpdate).waitControlIsNotInThePage();
        Assertions.assertFalse(projectSection.isProjectDisplayedInList(projectUpdate), "Error! Project was not deleted");

    }

}
