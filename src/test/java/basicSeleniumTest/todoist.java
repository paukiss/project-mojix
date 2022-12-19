package basicSeleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class todoist {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todoist.com/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {
//        crear, actualizar y eliminar un proyecto
        // login
        String email = "sergio_mojix@bootcamp.com";
        String pass = "123456789abc";
        driver.findElement(By.xpath("//div/ul//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[contains(@autocomplete, 'email')]")).sendKeys(email);
        driver.findElement(By.xpath("//input[contains(@autocomplete, 'current-password')]")).sendKeys(pass);
        driver.findElement(By.xpath("//button[contains(@data-gtm-id, 'start-email-login')]")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Projects']")));

//        Creacion project
        String nameProject = "nuevo project";
        driver.findElement(By.xpath("//a[@href='/app/projects']")).click();
        driver.findElement(By.xpath("//button/span[text()='Add project']")).click();
        driver.findElement(By.xpath("//input[@id='edit_project_modal_field_name']")).sendKeys(nameProject);
        driver.findElement(By.xpath("//button[text()='Add']")).click();

//        Update project
        driver.findElement(By.xpath("//h1/span[text()='"+nameProject+"']")).click();
        driver.findElement(By.xpath("//input[contains(@aria-label, 'Name')]")).clear();
        driver.findElement(By.xpath("//input[contains(@aria-label, 'Name')]")).sendKeys("update anme");
        driver.findElement(By.xpath("//span[text()='Save']")).click();


//        delete project
        driver.findElement(By.xpath("//button[@aria-label='Project options menu']")).click();
        driver.findElement(By.xpath("//div[text()='Delete project']")).click();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();

        Thread.sleep(1000);

    }
}
