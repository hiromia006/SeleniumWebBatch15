package selenium.class_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindAllLinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.tagName("a"));

        for (WebElement element : list) {
            System.out.println(element.getText() + " URL : " + element.getAttribute("href"));
        }

        driver.quit();

    }
}
