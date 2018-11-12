package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageCucumber {

    private final String homePageUrl = "https://epam.github.io/JDI/";

    public HomePageCucumber() {
        page(this);
    }

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "ul.uui-navigation.nav > li")
    private ElementsCollection navigationElements;

    @FindBy(css = "ul.dropdown-menu> li")
    private ElementsCollection serviceHeaderDropDownElements;

    @FindBy(css = ".sidebar-menu > li ")
    private ElementsCollection leftDropDownElements;

    @FindBy(css = ".sidebar-menu .menu-title [class = 'sub'] li > a")
    private ElementsCollection serviceLeftDropDownElements;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection images;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderIcons;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainHeader;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement subMainHeaderText;

    private static final String regex = "\"([^\"]*)\"";


    //================================methods===================================

    @Given("I am on Home Page")
    public void openPage() {
        open(homePageUrl);
    }

    @When("I login with login " + regex + " password " + regex)
    public void loginWithPassword(String name, String inpassword) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(inpassword);
        submit.click();
    }

    @When("I login as user " + regex)
    public void loginUser(String name) {
        name = name.replace(" ", "_");
        profileButton.click();
        login.sendKeys(Users.valueOf(name.toUpperCase()).login);
        password.sendKeys(Users.valueOf(name.toUpperCase()).password);
        submit.click();
    }

    @When("I open " + regex + " page by header menu " + regex)
    public void chooseServiceOption(String option, String menu) {
        navigationElements.findBy(text(menu)).click();
        serviceHeaderDropDownElements.findBy(text(option)).click();
    }

    @When("I click on " + regex + " button in Header")
    public void clickOnHeader(String section) {
        navigationElements.findBy(text(section)).click();
    }

    @When("I click on " + regex + " button in Service dropdown")
    public void clickOnHeaderSection(String section) {
        serviceHeaderDropDownElements.findBy(text(section)).click();
    }

    @When("I click on " + regex + " subcategory in the left section")
    public void clickOnLeftSection(String section) {
        leftDropDownElements.findBy(text(section)).click();
    }

    //================================checks===================================

    @And("The following elements is displayed: (\\d+) pictures, (\\d+) texts under pictures, headline and description texts")
    public void checkElements(int numberImages, int numberTexts) {
        images.shouldHaveSize(numberImages);
        images.forEach(SelenideElement::isDisplayed);
        textsUnderIcons.shouldHaveSize(numberTexts);
        textsUnderIcons.forEach(SelenideElement::isDisplayed);
        mainHeader.shouldBe(visible);
        mainHeader.shouldBe(visible);
    }

    @Then("The browser title is " + regex)
    public void checkBrowserTitle(String name) {
        assertEquals(getWebDriver().getTitle(), name);
    }

    @Then("Username now is " + regex)
    public void checkUserName(String username) {
        assertEquals(profileButton.getText(), username);
    }

    @Then("Dropdown of header contains options:")
    public void checkHeaderServiceDropDown(DataTable options) {
        List<String> strings = options.asList();
        serviceHeaderDropDownElements.shouldHaveSize(strings.size());
        serviceHeaderDropDownElements.shouldHave(exactTexts(strings));
    }

    @Then("Dropdown of left section contains options:")
    public void checkLeftServiceDropDown(DataTable options) {
        List<String> strings = options.asList();
        serviceLeftDropDownElements.shouldHaveSize(strings.size());
        serviceLeftDropDownElements.shouldHave(exactTexts(strings));
    }

}
