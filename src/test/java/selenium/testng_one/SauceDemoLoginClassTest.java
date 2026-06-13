package selenium.testng_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemoLoginClassTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        if (System.getProperty("os.name").toLowerCase().contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
//  Launch Firefox Browser
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test(priority = 0)
    public void testTittle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title is  matching");

    }

    @Test(priority = 1)
    public void validateUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "URL is  matching");

    }

    @Test(priority = 2)
    public void loginWithStandardUser() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        driver.findElement(By.id("react-burger-menu-btn")).click();
//
//        Thread.sleep(200);
//        String txt = driver.findElement(By.id("logout_sidebar_link")).getText();
//        System.out.println("Logout Text: " + txt);
//        Assert.assertEquals(txt, "Logout", "Logout link is  present");

//        driver.findElement(By.id("logout_sidebar_link")).click();


    }

    @Test(priority = 3)
    public void validatePlaceOrder() throws InterruptedException {
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#first-name")).sendKeys("John");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Doe");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("12345");
        driver.findElement(By.cssSelector("#continue")).click();
        String txt = driver.findElement(By.cssSelector(".summary_info_label")).getText();
        System.out.println("Checkout Text: " + txt);
        Assert.assertTrue(txt.contains("Payment"), "Checkout page is  displayed");
        Thread.sleep(2000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(200);
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @Test(priority = 4)
    public void loginWithProblem_user() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(200);
        String txt = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("Logout Text: " + txt);
        Assert.assertEquals(txt, "Logout", "Logout link is  present");
        Thread.sleep(200);

        driver.findElement(By.id("logout_sidebar_link")).click();


    }

    @Test(priority = 5)
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
