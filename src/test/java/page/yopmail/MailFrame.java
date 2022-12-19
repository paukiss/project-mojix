package page.yopmail;

import control.Button;
import control.Frame;
import control.TextArea;
import control.TextBox;
import org.openqa.selenium.By;


public class MailFrame {
    public TextBox messageTo = new TextBox(By.id("msgto"));
    public TextBox messageSubject = new TextBox(By.id("msgsubject"));
    public TextArea messageBody = new TextArea(By.id("msgbody"));
    public Button sendMsg = new Button(By.id("msgsend"));
    public Frame iframe = new Frame(By.id("ifmail"));
    public TextBox msgEmailPop = new TextBox(By.id("msgpopmsg"));

    public void sendMessage(String msgTo, String msgSubject, String msgBoby){
        messageTo.setText(msgTo);
        messageSubject.setText(msgSubject);
        messageBody.setText(msgBoby);
        sendMsg.click();
    }

}
