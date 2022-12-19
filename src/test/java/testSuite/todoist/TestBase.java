package testSuite.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoist.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginPageSession loginPageSession = new LoginPageSession();
    LoginSession loginSession = new LoginSession();
    OptionsProjectPage optionsProjectPage = new OptionsProjectPage();
    ProjectsPage projectsPage = new ProjectsPage();
    ProjectPageTask projectPageTask = new ProjectPageTask();
    EditTask editTask = new EditTask();
    OptionsTask optionsTask = new OptionsTask();
    String user = GetProperties.getInstance().getUser();
    String pass = GetProperties.getInstance().getPass();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
