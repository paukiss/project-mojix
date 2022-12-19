package page.yopmail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class MenuMailSection {
    public Button newEmail = new Button(By.id("newmail"));
    public Button refresh = new Button(By.id("refresh"));
    public TextBox numberMails = new TextBox(By.id("nbmail"));

}
