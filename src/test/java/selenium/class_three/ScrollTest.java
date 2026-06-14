package selenium.class_three;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-down.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to the bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        Thread.sleep(2000);
        // Scroll to the top
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);


        driver.quit();
    }
}
