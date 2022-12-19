package page.todoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginPageSession {
    public TextBox emailTxt = new TextBox(By.xpath("//input[contains(@autocomplete, 'email')]"));
    public TextBox pwdTxt = new TextBox(By.xpath("//input[contains(@autocomplete, 'current-password')]"));
    public Button loginButton = new Button(By.xpath("//button[contains(@data-gtm-id, 'start-email-login')]"));

}
