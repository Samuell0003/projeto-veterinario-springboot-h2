package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeterinarioTest {

    @Test
    public void adicionarVeterinario() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/home");

        WebElement create = driver.findElement(By.xpath("/html/body/div[2]/a[1]"));
        create.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
        name.sendKeys("Samuel Lucas");
        WebElement email = driver.findElement(By.xpath("//*[@id=\"inputEmail\"]"));
        email.sendKeys("samuel@gmail.com");
        WebElement speciality = driver.findElement(By.xpath("//*[@id=\"inputEspecialidade\"]"));
        speciality.sendKeys("cirurgiao");
        WebElement income = driver.findElement(By.xpath("//*[@id=\"inputSalario\"]"));
        income.sendKeys("4500");

        WebElement save = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
        save.click();

        WebElement customerSave = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[1]/span"));
        assertEquals(customerSave.getText(), "Samuel Lucas");
        WebElement specialitySave = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[2]"));
        assertEquals(specialitySave.getText(), "cirurgiao");
        WebElement emailSave = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[3]"));
        assertEquals(emailSave.getText(), "samuel@gmail.com");
        WebElement salario = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[4]"));
        assertEquals(salario.getText(), "R$4500.00");

        driver.close();
    }
    
}
