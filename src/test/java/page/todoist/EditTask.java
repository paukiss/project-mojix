package page.todoist;

import control.Button;
import control.TextArea;
import control.TextBox;
import org.openqa.selenium.By;

public class EditTask {
    public Button taskNameList = new Button(By.xpath("//div[@class='markdown_content task_content']"));
    public Button nameTaskActivate = new Button(By.xpath("//div[@aria-label='Task name']"));
    public TextBox nameTask = new TextBox(By.xpath("//div/form/div/div/div/div/div/div/div/div/div/div/span"));
    public TextBox newNameTask = new TextBox(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']/span"));
    public TextArea descriptionTask = new TextArea(By.xpath("//textarea[@style='height: 42px !important;']"));
    public Button saveTask = new Button(By.xpath("//button/span[text()='Save']"));

}
