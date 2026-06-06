package selenium.class_three;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TableTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.cssSelector("table[id='customers'] tbody"));

        for (WebElement element1 : element.findElements(By.tagName("tr"))) {
            for (WebElement element2 : element1.findElements(By.tagName("td"))) {
                System.out.print(element2.getText() + ", ");
            }
            System.out.println();
        }

        driver.quit();
    }
}
