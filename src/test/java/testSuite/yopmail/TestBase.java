package testSuite.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopmail.CreateEmail;
import page.yopmail.MailFrame;
import page.yopmail.MenuMailSection;
import session.Session;
import util.GetProperties;

public class TestBase {
    CreateEmail createEmail = new CreateEmail();
    MailFrame mailFrame = new MailFrame();
    MenuMailSection menuMailSection = new MenuMailSection();

    @BeforeEach
    public void openBrowser(){
        // todo properties
        Session.getInstance().getBrowser().get("https://yopmail.com/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
