package selenium.class_three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElements(By.tagName("h1"))
                .forEach(e -> System.out.println(e.getText()));

        driver.switchTo().frame(0);
        System.out.println("Switching to frame 1");
        driver.findElements(By.tagName("a"))
                .forEach(e -> System.out.println(e.getText() + " URL : " + e.getAttribute("href")));

        driver.switchTo().defaultContent();



        driver.switchTo().frame(1);

        System.out.println("Switching to frame 2");
        driver.findElements(By.tagName("a"))
                .forEach(e -> System.out.println(e.getText() + " URL : " + e.getAttribute("href")));

        driver.switchTo().defaultContent();

        driver.quit();


    }
}
