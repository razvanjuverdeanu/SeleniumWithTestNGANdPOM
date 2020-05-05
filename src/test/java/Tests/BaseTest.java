package Tests;

import component.AliExpressDriver;
import config.ApplicationContextConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

@ContextConfiguration(classes = ApplicationContextConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public AliExpressDriver driver;

    @Autowired
    public HomePage homePage;

    @Autowired
    public SearchPage searchPage;

    @Autowired
    public LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void createTestContext(ITestContext context) {
        context.setAttribute("driver", driver.getDriver());
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver.get(driver.getBaseUrl());
        homePage.closeCoupon();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.closeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void goToHomePage() {
        driver.get(driver.getBaseUrl());
        homePage.closeCoupon();
    }
}