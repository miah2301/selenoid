import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidDriverProvider implements WebDriverProvider {


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability("enableVNC", true);
//        browser.setCapability("screenResolution", "680x124x24"); // размер экрана

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://212.193.51.177:4444/wd/hub").toURL(),
                    capabilities
            );
//            driver.manage().window().setSize(new Dimension(1280, 1024)); ставить в селениде
//            driver.manage().window().maximize();
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

