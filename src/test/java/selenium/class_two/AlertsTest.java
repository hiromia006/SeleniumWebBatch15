package selenium.class_two;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button[onclick='showAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        String txt = alt.getText();
        System.out.println(txt);
        alt.dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        Thread.sleep(2000);

        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Selenium WebDriver");
        Thread.sleep(2000);
        System.out.println("Alert Text :" + alert2.getText());
        alert2.accept();

        Thread.sleep(2000);


        driver.quit();


    }
}
