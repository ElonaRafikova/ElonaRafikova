package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.HeaderSections.*;
import static enums.TextsUnderIcons.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    private final String homePageUrl = "https://epam.github.io/JDI/";
    private final String homePageBrowserTitle = "Home Page";
    private final String mainHeaderText = "EPAM FRAMEWORK WISHES…";
    private final String underMainHeaderText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
            " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM," +
            " QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE" +
            " DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private final String subHeaderText = "JDI GITHUB";
    private final String subHeaderUrl = "https://github.com/epam/JDI";

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = "ul.uui-navigation.nav > li")
    private List<WebElement> navigationElements;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderIcons;

    @FindBy(css = "h3.main-title")
    private WebElement mainHeader;

    @FindBy(css = ".main-txt.text-center")
    private WebElement subMainHeaderText;

    @FindBy(css = "[id=iframe]")
    private WebElement iFrame;

    @FindBy(css = "[id=epam_logo]")
    private WebElement logo;

    @FindBy(css = ".main-content > h3.text-center > [target=_blank]")
    private WebElement subHeader;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement footer;


    //================================methods===================================

    public void open(WebDriver driver) {
        driver.navigate().to(homePageUrl);
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void switchToFrame(WebDriver driver) {
        driver.switchTo().frame(iFrame);
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }


    //================================checks===================================

    public void checkBrowserTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), homePageBrowserTitle);
    }


    public void checkUserName(String userName) {
        assertTrue(profileButton.isDisplayed());
        assertEquals(profileButton.getText(), userName);
    }

    public void checkNavigationElements() {
        assertEquals(navigationElements.size(), 4);
        assertEquals(navigationElements.get(0).getText(), HOME.title);
        assertEquals(navigationElements.get(1).getText(), CONTACT_FORM.title);
        assertEquals(navigationElements.get(2).getText(), SERVICE.title);
        assertEquals(navigationElements.get(3).getText(), METALS_COLORS.title);
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTextUnderImages() {
        assertEquals(textsUnderIcons.size(), 4);
        assertEquals(textsUnderIcons.get(0).getText(), GOOD_PRACTICES.text);
        assertEquals(textsUnderIcons.get(1).getText(), FLEXIBLE.text);
        assertEquals(textsUnderIcons.get(2).getText(), MULTIPLATFORM.text);
        assertEquals(textsUnderIcons.get(3).getText(), GOOD_BASE.text);
    }

    public void checkMainHeader() {
        assertTrue(mainHeader.isDisplayed());
        assertEquals(mainHeader.getText(), mainHeaderText);
    }

    public void checkTextUnderMainHeader() {
        assertTrue(subMainHeaderText.isDisplayed());
        assertEquals(subMainHeaderText.getText(), underMainHeaderText);
    }

    public void checkFrame() {
        assertTrue(iFrame.isDisplayed());
    }

    public void checkLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void checkSubHeader() {
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), subHeaderText);
    }

    public void checkSubHeaderLink() {
        assertEquals(subHeader.getAttribute("href"), subHeaderUrl);
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }


}