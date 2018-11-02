package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHAILOVSKII;

public class HomePageObjectTest extends TestBase {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void homePageObjectTest() {

        //1 Open test site by URL
        homePage.open(driver);

        //2 Assert Browser title
        homePage.checkBrowserTitle(driver);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII.name);

        //5 Assert Browser title
        homePage.checkBrowserTitle(driver);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNavigationElements();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextUnderImages();

        //9 Assert a text of the main header
        //main header
        homePage.checkMainHeader();
        //main text
        homePage.checkTextUnderMainHeader();

        //10 Assert that there is the iframe in the center of page
        homePage.checkFrame();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToFrame(driver);
        homePage.checkLogo();

        //12 Switch to original window back
        homePage.switchToParentFrame(driver);

        //13 Assert a text of the sub header
        homePage.checkSubHeader();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLink();

        //15 Assert that there is Left Section
        homePage.checkLeftSection();

        //16 Assert that there is Footer
        homePage.checkFooter();

    }
}