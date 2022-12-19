package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class OptionsTask {
    public Button optionsTask = new Button(By.xpath("//button[contains(@aria-label,'More actions')]"));
    public Button deleteTask = new Button(By.xpath("//button[contains(@aria-label,'Delete task')]"));
    public Button confirmDeleteTask = new Button(By.xpath("//button/span[text()='Delete']"));
}
