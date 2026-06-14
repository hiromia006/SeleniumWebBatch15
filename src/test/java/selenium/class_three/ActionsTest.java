package selenium.class_three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions acts = new Actions(driver);
        Thread.sleep(2000);
        WebElement source = driver.findElement(By.cssSelector("div[id='draggable'] p"));
        WebElement target = driver.findElement(By.id("droppable"));
        acts.dragAndDrop(source, target).perform();
        Thread.sleep(2000);

        acts.contextClick(target).perform();
        Thread.sleep(2000);


        driver.quit();

    }
}
