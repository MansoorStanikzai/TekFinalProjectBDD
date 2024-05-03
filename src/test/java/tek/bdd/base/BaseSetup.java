package tek.bdd.base;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class BaseSetup {
    private static WebDriver driver;
    private final Properties properties = new Properties();

    public BaseSetup() {
        try {
            String fileFilePath = System.getProperty("user.dir") + ("/src/test/resources/config/application-config.properties");
            File propertiesFile = new File(fileFilePath);
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

            properties.load(propertyFileInputStream);

        } catch (IOException ex) {
            throw new RuntimeException("Can not read or load config file "
                    + ex.getMessage());
        }

    }

    public void openBrowser() {
        String browserType = this.properties.getProperty("retail.browser.type");

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Wrong browser Type");
        }

        driver.manage().window().maximize();
        String url = this.properties.getProperty("retail.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
