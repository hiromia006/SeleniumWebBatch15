package selenium.class_three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElements(By.tagName("a"))
                .forEach(e -> System.out.println(e.getText() + " URL : " + e.getAttribute("href")));

        WebDriver.Navigation navigation = driver.navigate();

        navigation.to("https://www.selenium.dev/");
        System.out.println("Navigate to Selenium Dev ---------------------");
        Thread.sleep(2000);
        navigation.back();
        Thread.sleep(2000);
        System.out.println("Navigate back to main Tab ---------------------");
        Thread.sleep(2000);
        navigation.forward();
        System.out.println("Navigate forward to Selenium Dev ---------------------");
        Thread.sleep(2000);
        navigation.refresh();
        System.out.println("Refresh the page ---------------------");

//        driver.navigate().to("https://www.selenium.dev/");
//        System.out.println("Navigate to Selenium Dev ---------------------");
//
//        Thread.sleep(200);
//        driver.navigate().back();
//        System.out.println("Navigate back to main Tab ---------------------");
//        driver.navigate().forward();
//        System.out.println("Navigate forward to Selenium Dev ---------------------");
//        driver.navigate().refresh();
//        System.out.println("Refresh the page ---------------------");

        Thread.sleep(2000);
        driver.quit();

    }
}
