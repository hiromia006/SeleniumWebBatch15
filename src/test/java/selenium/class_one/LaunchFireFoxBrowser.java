package selenium.class_one;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFoxBrowser   {
    public static void main(String[] args) {

        // Please skip below two lines if you have set the geckodriver path in your system environment variables
        if (System.getProperty("os.name").toLowerCase().contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
//  Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();

        System.out.println("Title of the page is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        driver.quit();

    }
}
