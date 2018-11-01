package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import enums.HeaderSections;
import enums.LeftSections;
import enums.ServiceDropDowns;
import enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.HeaderSections.*;
import static enums.ServiceDropDowns.getServiceDropDownsTitles;
import static enums.ServiceDropDowns.getServiceDropDownsTitlesUpper;
import static enums.TextsUnderIcons.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenide {

    private final String homePageUrl = "https://epam.github.io/JDI/";
    private final String homePageBrowserTitle = "Home Page";
    private String mainHeaderText = "EPAM FRAMEWORK WISHES…";
    private String underMainHeaderText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
            " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM," +
            " QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE" +
            " DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private String subHeaderText = "JDI GITHUB";
    private String subHeaderUrl = "https://github.com/epam/JDI";

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

    @FindBy(css = "ul.sidebar-menu > ")
    private ElementsCollection sidebarMenuElements;

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

    @FindBy(css = "ul.dropdown-menu> li")
    private ElementsCollection serviceHeaderDropDownElements;

    @FindBy(css = ".sidebar-menu > li ")
    private ElementsCollection leftDropDownElements;

    @FindBy(css = ".sidebar-menu .menu-title [class = 'sub'] li > a")
    private ElementsCollection serviceLeftDropDownElements;

    //================================methods===================================

    public void openPage() {
        open(homePageUrl);
    }

    public void checkBrowserTitle() {
        assertEquals(getWebDriver().getTitle(), homePageBrowserTitle);
    }

    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    public void clickOnHeader(HeaderSections section) {
        navigationElements.get(section.ordinal()).click();
    }

    public void clickOnLeftSection(LeftSections section) {
        leftDropDownElements.get(section.ordinal()).click();
    }

    //================================checks===================================

    public void checkUserName(Users user) {
        assertTrue(profileButton.isDisplayed());
        assertEquals(profileButton.getText(), user.name);
    }

    public void checkHeaderServiceDropDown() {
        serviceHeaderDropDownElements.shouldHaveSize(getServiceDropDownsTitlesUpper().size());
        serviceHeaderDropDownElements.shouldHave(exactTexts(getServiceDropDownsTitlesUpper()));
    }

    public void checkLeftServiceDropDown() {
        serviceLeftDropDownElements.shouldHaveSize(getServiceDropDownsTitles().size());
        serviceLeftDropDownElements.shouldHave(exactTexts(getServiceDropDownsTitles()));
    }


    public void chooseServiceOption(ServiceDropDowns option) {
        serviceHeaderDropDownElements.get(option.ordinal()).click();
    }
}
