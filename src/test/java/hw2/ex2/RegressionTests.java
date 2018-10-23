package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressionTests {
    @Test(groups = "Regression")
    public void firstTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Prepare driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationElements = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li"));
        assertEquals(navigationElements.size(), 4);

        assertEquals(navigationElements.get(0).getText(), "HOME");
        assertEquals(navigationElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navigationElements.get(2).getText(), "SERVICE");
        assertEquals(navigationElements.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);

        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.size(), 4);

        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        //main header
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        //main text
        WebElement mainText = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM," +
                " QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE" +
                " DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id=iframe]"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement logo = driver.findElement(By.cssSelector("[id=epam_logo]"));
        assertTrue(logo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".main-content > h3.text-center > [target=_blank]"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("[name='navigation-sidebar']"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector(".footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
    @Test(groups = "Regression")
    public void secondTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Prepare driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationElements = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li"));
        assertEquals(navigationElements.size(), 4);

        assertEquals(navigationElements.get(0).getText(), "HOME");
        assertEquals(navigationElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navigationElements.get(2).getText(), "SERVICE");
        assertEquals(navigationElements.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);

        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.size(), 4);

        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        //main header
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        //main text
        WebElement mainText = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM," +
                " QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE" +
                " DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id=iframe]"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement logo = driver.findElement(By.cssSelector("[id=epam_logo]"));
        assertTrue(logo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".main-content > h3.text-center > [target=_blank]"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("[name='navigation-sidebar']"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector(".footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
    @Test(groups = "Regression")
    public void thirdTest() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Prepare driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationElements = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li"));
        assertEquals(navigationElements.size(), 4);

        assertEquals(navigationElements.get(0).getText(), "HOME");
        assertEquals(navigationElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navigationElements.get(2).getText(), "SERVICE");
        assertEquals(navigationElements.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);

        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.size(), 4);

        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        //main header
        WebElement mainHeader = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        //main text
        WebElement mainText = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
                " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM," +
                " QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE" +
                " DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id=iframe]"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement logo = driver.findElement(By.cssSelector("[id=epam_logo]"));
        assertTrue(logo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".main-content > h3.text-center > [target=_blank]"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("[name='navigation-sidebar']"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector(".footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
