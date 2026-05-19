package selenium.class_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SauceDemoLoginCssSelectorTest {
    public static void main(String[] args) throws InterruptedException {
        // Please skip below two lines if you have set the geckodriver path in your system environment variables
        if (System.getProperty("os.name").toLowerCase().contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
//  Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);

        String str = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']")).getText();
        System.out.println("First product name is: " + str);

        String string = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']")).getAttribute("class");
        System.out.println("First product name class attribute value is: " + string);

        driver.quit();

    }
}
