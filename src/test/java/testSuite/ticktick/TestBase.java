package testSuite.ticktick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
