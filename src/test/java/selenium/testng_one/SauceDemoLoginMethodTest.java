package selenium.testng_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoLoginMethodTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testTittle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title is  matching");

    }

    @Test
    public void validateUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "URL is  matching");

    }

    @Test
    public void loginWithStandardUser() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("Logout Text: " + txt);
        Assert.assertEquals(txt, "Logout", "Logout link is  present");


    }

    @Test
    public void loginWithProblem_user() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("Logout Text: " + txt);
        Assert.assertEquals(txt, "Logout", "Logout link is  present");


    }

    @Test
    public void loginWithLocked_out_user() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(200);
        String txt = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        System.out.println("Logout Text: " + txt);
        Assert.assertTrue(txt.contains("locked"), "Error message is matching");

    }
}
