package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

public class ProjectsPage {
    public Button newProject = new Button(By.xpath("//a[@href='/app/projects']"));
    public Button addProject = new Button(By.xpath("//button/span[text()='Add project']"));
    public TextBox nameProject = new TextBox(By.xpath("//input[@id='edit_project_modal_field_name']"));
    public Button addNewProject = new Button(By.xpath("//button[text()='Add']"));
    public TextBox newNameProject = new TextBox(By.xpath("//input[contains(@aria-label, 'Name')]"));
    public Button saveProject = new Button(By.xpath("//span[text()='Save']"));
    public Label nameProjectHeader = new Label(By.xpath("//h1/span[contains(@class,'simple_content')]"));
    public void clickOnNameProject(String nameProject){
        TextBox projectCreated = new TextBox((By.xpath("//h1/span[text()='"+nameProject+"']")));
        projectCreated.click();
    }

    public void selectNameProjectToAddTask(String nameProject){
        Button nameProjectSelected = new Button(By.xpath("//div[text()='"+nameProject+"']"));
        nameProjectSelected.click();
    }

}
