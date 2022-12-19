package testSuite.ticktick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.ticktick.LoginPageSession;
import page.ticktick.LoginSession;
import session.Session;
import util.GetProperties;

public class TestBase {

    LoginSession loginSession = new LoginSession();

    LoginPageSession loginPageSession = new LoginPageSession();


    String user = "sergiopaucara@gmail.com";
    String pass = "mojix123456:v";

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
