package selenium.testng_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoLoginHeadlessTest {
    @Test
    public void testTittle(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title is  matching");
        driver.quit();
    }

    @Test
    public void validateUrl(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "URL is  matching");
        driver.quit();
    }

    @Test
    public void loginWithStandardUser() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt=driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("Logout Text: "+txt);
        Assert.assertEquals(txt, "Logout", "Logout link is  present");

        driver.quit();
    }

    @Test
    public void loginWithProblem_user() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt=driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("Logout Text: "+txt);
        Assert.assertEquals(txt, "Logout", "Logout link is  present");

        driver.quit();
    }

    @Test
    public void loginWithLocked_out_user() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt=driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        System.out.println("Logout Text: "+txt);
       Assert.assertTrue(txt.contains("locked"), "Error message is matching");

        driver.quit();
    }
}
