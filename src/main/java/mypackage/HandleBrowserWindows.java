package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
       //getwindowhandle()
/*
        String windowID = driver.getWindowHandle();
        System.out.println(windowID);*/

        //getwindowhandles()
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIds =driver.getWindowHandles();

        //First methdd -->Iterator()
      /*  Iterator<String> it1 = windowIds.iterator();
        String parentwindowID=  it1.next();
        String childwindowID  = it1.next();
        System.out.println("Parent Window id:"+parentwindowID);
        System.out.println("child Window id:"+childwindowID);
*/


        //Second Method--->List/ArrayList

        //List<String> windowIDList = new ArrayList( windowIds );//converting set into list
       /* String parentwindowID = windowIDList.get(0);//paretn window id
        String childwindowID  =windowIDList.get(1); //Child window id
        System.out.println("Parent Window id:"+parentwindowID);
        System.out.println("child Window id:"+childwindowID);

        //How to use these ids for swritching

        driver.switchTo().window(parentwindowID);
        System.out.println("Parent window Title:"+driver.getTitle());
        driver.switchTo().window(childwindowID);
        System.out.println("Child window Title:"+driver.getTitle());*/

        //**********By using For Each loop****************

        for (String ids:windowIds)
        {
            System.out.println(ids);
            String title = driver.switchTo().window(ids).getTitle();
            System.out.println( title);
        }




    }
}
