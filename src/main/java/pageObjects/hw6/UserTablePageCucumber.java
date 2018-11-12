package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class UserTablePageCucumber {

    private static final String regex = "\"([^\"]*)\"";

    public UserTablePageCucumber() {
        page(this);
    }

    @FindBy(css = "#user-table tr td:nth-child(1)")
    private ElementsCollection numbers;

    @FindBy(css = "#user-table tr >td >select")
    private ElementsCollection dropdowns;

    @FindBy(css = "#user-table tr >td >a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table tr >td >img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "#user-table tr >td >div>span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table tr >td >div>input")
    private ElementsCollection checkboxes;

    @FindBy(css = "ul.panel-body-list.logs> li")
    private ElementsCollection logs;


    //---------------------methods-----------------------------------------------------------//

    @When("I select 'vip' checkbox for " + regex)
    public void selectVipCheckbox(String name) {
        int i = userNames.indexOf(userNames.findBy(text(name)));
        checkboxes.get(i).click();
    }

    @When("I click on dropdown in column Type for user Roman")
    public void clickOnDropDown() {
        dropdowns.get(userNames.indexOf(userNames.findBy(text("Roman")))).click();
    }


    //---------------------checks------------------------------------------------------------//

    @Then(regex + " page is opened")
    public void checkPageOpen(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkDropdownsAreDisplayed(int count) {
        dropdowns.shouldHaveSize(count);
        dropdowns.forEach(SelenideElement::isDisplayed);

    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkImagesAreDisplayed(int count) {
        descriptionImages.shouldHaveSize(count);
        descriptionImages.forEach(SelenideElement::isDisplayed);

    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkUserNamesAreDisplayed(int count) {
        userNames.shouldHaveSize(count);
        userNames.forEach(SelenideElement::isDisplayed);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkTextsAreDisplayed(int count) {
        descriptionTexts.shouldHaveSize(count);
        descriptionTexts.forEach(SelenideElement::isDisplayed);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkCheckboxesAreDisplayed(int count) {
        checkboxes.shouldHaveSize(count);
        checkboxes.forEach(SelenideElement::isDisplayed);
    }

    @And("User table contains following values:")
    public void checkUserTable(DataTable table) {
        List<Map<String, String>> maps = table.asMaps(String.class, String.class);
        assertEquals(maps.size(), numbers.size());

        int i = 0;
        for (Map<String, String> map : maps) {
            numbers.get(i).shouldHave(text(map.get("Number")));
            userNames.get(i).shouldHave(text(map.get("User")));
            descriptionTexts.get(i).shouldHave(text(map.get("Description")));
            i++;
        }

    }

    @Then("^(\\d+) log row has " + regex + " text in log section$")
    public void checkLog(int number, String name) {
        logs.shouldHaveSize(number);
        logs.shouldHave(texts(name));

    }

    @Then("droplist contains values")
    public void checkDropList(DataTable values) {
        List<String> strings = values.asList();
        ElementsCollection option = dropdowns.find(Condition.focused).$$("option");
        option.shouldHave(texts(strings.subList(1, strings.size())));
    }


}
