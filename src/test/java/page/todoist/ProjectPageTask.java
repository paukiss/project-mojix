package page.todoist;

import control.Button;
import control.TextArea;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectPageTask {
    public Button plusAddTask = new Button(By.xpath("//li/button[@class='plus_add_button']"));
    public TextBox taskName = new TextBox(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']"));
    public TextArea description = new TextArea(By.xpath("//textarea[contains(@placeholder, 'Description')]"));
    public Button addTask = new Button(By.xpath("//span[text()='Add task']"));


}
