package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws MalformedURLException {
        String gridURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
