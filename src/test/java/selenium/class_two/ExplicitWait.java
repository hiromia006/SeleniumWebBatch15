package selenium.class_two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button[onclick='showAlert()']")).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myDesk()']")));
        driver.findElement(By.xpath("//button[@onclick='myDesk()']"));

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
