package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import enums.HeaderSections;
import enums.LeftSections;
import enums.ServiceDropDowns;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceDropDowns.getServiceDropDownsTitles;
import static enums.ServiceDropDowns.getServiceDropDownsTitlesUpper;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenide {

    private final String homePageUrl = "https://epam.github.io/JDI/";
    private final String homePageBrowserTitle = "Home Page";

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

    @FindBy(css = "ul.dropdown-menu> li")
    private ElementsCollection serviceHeaderDropDownElements;

    @FindBy(css = ".sidebar-menu > li ")
    private ElementsCollection leftDropDownElements;

    @FindBy(css = ".sidebar-menu .menu-title [class = 'sub'] li > a")
    private ElementsCollection serviceLeftDropDownElements;


    //================================methods===================================

    @Step
    public void openPage() {
        open(homePageUrl);
    }

    @Step
    public void checkBrowserTitle() {
        assertEquals(getWebDriver().getTitle(), homePageBrowserTitle);
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }


    @Step
    public void clickOnHeader(HeaderSections section) {
        navigationElements.get(section.ordinal()).click();
    }

    @Step
    public void clickOnLeftSection(LeftSections section) {
        leftDropDownElements.get(section.ordinal()).click();
    }

    //================================checks===================================

    @Step
    public void checkUserName(Users user) {
        assertTrue(profileButton.isDisplayed());
        assertEquals(profileButton.getText(), user.name);
    }

    @Step
    public void checkHeaderServiceDropDown() {
        serviceHeaderDropDownElements.shouldHaveSize(getServiceDropDownsTitlesUpper().size());
        serviceHeaderDropDownElements.shouldHave(exactTexts(getServiceDropDownsTitlesUpper()));
    }

    @Step
    public void checkLeftServiceDropDown() {
        serviceLeftDropDownElements.shouldHaveSize(getServiceDropDownsTitles().size());
        serviceLeftDropDownElements.shouldHave(exactTexts(getServiceDropDownsTitles()));
    }

    @Step
    public void chooseServiceOption(ServiceDropDowns option) {
        serviceHeaderDropDownElements.get(option.ordinal()).click();
    }
}
