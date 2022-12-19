package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class LoginSession {
    public Button loginButton = new Button(By.xpath("//div/ul//a[text()='Log in']"));
}
