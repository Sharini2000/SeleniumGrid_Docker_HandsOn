package ParallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {

    WebDriver driver;
    @BeforeTest
    @Parameters({"broswerType"})
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        if(browser.equalsIgnoreCase("edge"))
        {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }

    }

    @Test
    public void SeleniumCrowBrowserTests() throws InterruptedException {
        driver.get("https://chatgpt.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //WebElement msgbox = webdriver.findElement(By.id("prompt-textarea"));
        //msgbox.sendKeys("Tell me a story, please");
        //Thread.sleep(2000);
        String expectedtitle = "ChatGPT";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(expectedtitle,actualtitle);
        driver.close();
    }
}
