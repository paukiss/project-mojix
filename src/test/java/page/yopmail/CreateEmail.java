package page.yopmail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class CreateEmail {
    public TextBox emailTxt = new TextBox(By.id("login"));
    public Button inboxButton = new Button(By.xpath("//button[contains(@title,'Check Inbox @yopmail.com')]"));

    public void createEmailAndLogin(String email){
        emailTxt.setText(email);
        inboxButton.click();
    }
}
