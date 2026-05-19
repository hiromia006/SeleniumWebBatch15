package selenium.class_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;

public class SauceDemoLoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Please skip below two lines if you have set the geckodriver path in your system environment variables
        if (System.getProperty("os.name").toLowerCase().contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
//  Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
