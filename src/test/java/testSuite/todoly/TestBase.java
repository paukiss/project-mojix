package testSuite.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoly.LoginSession;
import page.todoly.MainPage;
import page.todoly.MenuSection;
import page.todoly.ProjectSection;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginSession loginSession = new LoginSession();
    MenuSection menuSection = new MenuSection();
    ProjectSection projectSection = new ProjectSection();

    String user = GetProperties.getInstance().getUser();
    String pass = GetProperties.getInstance().getPass();

    @BeforeEach
    public void openBrowser(){
        // todo properties
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
