package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ResourceBundle;


public class AppTest {
    WebDriver driver;

    //make 3 methods for setup,close,getTitle
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser,String link) throws InterruptedException {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }


        driver.get(link);
        driver.manage().window().maximize(); //for window to maximize
        Thread.sleep(3000);
    }

    @Test
    public void googleTest() throws InterruptedException {
          ResourceBundle r =ResourceBundle.getBundle("config");
          String user=r.getString("username");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user);
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//input[@id='iBtnLogins']")).click();

    }
    @AfterClass
    void close(){
        driver.close();
    }

}
