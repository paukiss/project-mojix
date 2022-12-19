package basicSeleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class BasicSeleniumTestTask {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://todo.ly/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {

        // login
        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("bootcamp@mojix44.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                ,"ERROR login was incorrect");

        // create
        String nameProject="Sergio_"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        // create task
        String nameTask="Sergio new task";
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameTask);
        driver.findElement(By.id("NewItemAddButton")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath("//td/div[text()='"+nameTask+"']")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The task was not created");

        // update task
        String newNameTask="Update_SergioTask_"+new Date().getTime();
        driver.findElement(By.xpath("//td/div[text()='"+nameTask+"']")).click();
        driver.findElement(By.xpath("//div/textarea[@id='ItemEditTextbox']")).clear();
        driver.findElement(By.xpath("//div/textarea[@id='ItemEditTextbox']")).sendKeys(newNameTask);
        Thread.sleep(1000);

        actualResult=driver.findElements(By.xpath("//td/div[text()='"+ newNameTask+"']")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The task was not updated");
    }
}
