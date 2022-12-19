package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.yopmail.MailFrame;

import java.util.Date;

public class SendAndCheckEmail extends TestBase {
    @Test
    public void sendEmailAndCheckReceive() {
        String email = "sergiopaucara@yopmail.com";
        String msgSubject = "Saludo a mi mismo!";
        String msgBody = "Hola como estas";

        createEmail.createEmailAndLogin(email);
        Assertions.assertTrue(menuMailSection.newEmail.isControlDisplayed(), "Error! the login");

        menuMailSection.newEmail.click();
        mailFrame.iframe.switchFrame("ifmail");
        mailFrame.sendMessage(email, msgSubject, msgBody);
        mailFrame.msgEmailPop.waitControlIsNotVisibleElement();
        Assertions.assertTrue(mailFrame.msgEmailPop.isControlDisplayed(), "Error! Messagge was not send");

        mailFrame.iframe.switchDefaultFrame();
        String lastNumberMsg = menuMailSection.numberMails.getText();
        menuMailSection.refresh.click();
        mailFrame.iframe.switchFrame("ifmail");
        mailFrame.msgEmailPop.waitControlIsNoShowed();
        mailFrame.iframe.switchDefaultFrame();
        String currectNumberMsg = menuMailSection.numberMails.getText();
        Assertions.assertNotEquals(lastNumberMsg, currectNumberMsg, "Error! Email was not receive");
    }
}
