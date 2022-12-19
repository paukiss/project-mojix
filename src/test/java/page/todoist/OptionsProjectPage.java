package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class OptionsProjectPage {
    public Button optionsProject = new Button(By.xpath("//button[@aria-label='Project options menu']"));
    public Button deleteOption = new Button(By.xpath("//div[text()='Delete project']"));
    public Button confirmDelete = new Button(By.xpath("//button/span[text()='Delete']"));

}
