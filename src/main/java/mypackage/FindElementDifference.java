package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class FindElementDifference {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //findElement()----> single webelement
        WebElement searchbox =driver.findElement(By.xpath("//input[@id= 'small-searchterms']"));
        searchbox.sendKeys("Naveen");
       WebElement footerElement = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(footerElement.getText());

        //findElements--->Returns multipleWebElements

         List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
         System.out.println("Number of elements captured:"+links.size());
        for (WebElement e: links)
        {
            System.out.println(e.getText());

        }


    }
}
