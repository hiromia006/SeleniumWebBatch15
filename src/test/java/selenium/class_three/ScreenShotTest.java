package selenium.class_three;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShotTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Main Tab " + driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText());

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + "Main Window" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(2000);
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);
        driver.get("https://www.selenium.dev/");
        System.out.println("Switch new Tab ---------------------");
        driver.findElements(By.tagName("a"))
                .forEach(e -> System.out.println(e.getText() + " URL : " + e.getAttribute("href")));
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + "Main Window" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();

        Thread.sleep(2000);

        driver.switchTo().window(originalWindow);
        System.out.println("Switch back to main Tab ---------------------");

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + "Main Window" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
