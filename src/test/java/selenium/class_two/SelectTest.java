package selenium.class_two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        driver.findElement(By.id("name")).sendKeys("Jannat Mugdho");
        driver.findElement(By.id("gender")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("picture")).sendKeys("/home/jannat-mugdho/Pictures/other1/1779515491354.jpeg");
        Thread.sleep(2000);

        Select slt = new Select(driver.findElement(By.cssSelector("#state")));
         slt.selectByIndex(1);
         Thread.sleep(2000);
         slt.selectByValue("Rajasthan");
        Thread.sleep(2000);
        slt.selectByVisibleText("Uttar Pradesh");

        slt.getOptions().forEach(a -> System.out.println(a.getText()) );

//        List<WebElement> options = slt.getOptions();
//        for (WebElement a : options) {
//            System.out.println(a.getText());
//        }

         driver.quit();
    }
}
