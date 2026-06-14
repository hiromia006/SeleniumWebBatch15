package selenium.class_three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TabTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Main Tab "+driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText());

        Thread.sleep(2000);
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://www.selenium.dev/");
        System.out.println("Switch new Tab ---------------------");
        driver.findElements(By.tagName("a"))
                .forEach(e -> System.out.println(e.getText() + " URL : " + e.getAttribute("href")));

        driver.close();

        Thread.sleep(2000);

        driver.switchTo().window(originalWindow);
        System.out.println("Switch back to main Tab ---------------------");



        driver.quit();
    }
}
