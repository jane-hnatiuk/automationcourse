package automation.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static automation.hotline.constants.CoreConstants.WAIT_TIMEOUT;

public class BaseTest {

    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;

    @BeforeTest
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-fullscreen");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


    @AfterTest
    public void tearDownAll() throws Exception {
        //  driver.quit();
    }

}
