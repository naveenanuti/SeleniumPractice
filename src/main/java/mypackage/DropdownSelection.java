package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownSelection {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Create a Page']")).click();
        driver.findElement(By.id("email")).sendKeys("naveenreddyanuti@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("naveen@4225");
        driver.findElement(By.xpath("//a[@tabindex='4']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Naveen");
        driver.findElement(By.name("lastname")).sendKeys("Anuti");
        driver.findElement(By.name("reg_email__")).sendKeys("naveenreddyanuti@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("naveen@4225");
        //*****Dropdown values selecting
       Select days  =new Select(driver.findElement(By.id("day")));
       days.selectByIndex(20);
        Thread.sleep(2000);
       List<WebElement> drpdays =days.getOptions();
        for (WebElement e:drpdays)
        {
            //System.out.println(e);
            System.out.println(e.getText());
        }
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Jun");
        List <WebElement> monthItems =month.getOptions();
        for (WebElement items:monthItems)
        {
           System.out.println(items.getText());
        }
        Thread.sleep(3000);
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("1992");
        Thread.sleep(4000);

        //**************Radio buttons selecting
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("websubmit")).click();

        driver.quit();


    }
}


