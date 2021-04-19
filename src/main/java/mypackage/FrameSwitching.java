package mypackage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FrameSwitching {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.manage().window().maximize();
        //******To know how many frames are existed in webpage
        List<WebElement> iframes=driver.findElements(By.tagName("ifrmae"));
        int framenumber= iframes.size();
        System.out.println(framenumber);
        //how to switch frame
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("login_page");
        driver.switchTo().window("0");
        driver.findElement(By.name("fldLoginUserId")).sendKeys("65218793");
        driver.findElement(By.xpath("//img[@src='/gif/continue_new1.gif?v=1']")).click();
        //defaultcontent meethod used to switch control to the main page
        //driver.switchTo().defaultContent();
        //parentFrame method used to switch  control to the parentFrame of the current Frame
       // driver.switchTo().parentFrame();
        driver.close();

    }


}
