package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Colors;
import enums.RadioButtons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageCucumber {

    @FindBy(css = "ul.uui-navigation.nav > li")
    private List<WebElement> navigationElements;

    @FindBy(css = "ul.dropDown-menu")
    private SelenideElement serviceDropDown;

    @FindBy(css = "ul.dropDown-menu> li")
    private ElementsCollection serviceHeaderDropDownElements;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors > select")
    private SelenideElement dropDown;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement log;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logRecords;

    public DifferentElementsPageCucumber() {
        page(this);
    }

    private static final String regex = "\"([^\"]*)\"";


    //================================methods===================================

    @When("I select checkboxes " + regex + " and " + regex)
    public void selectCheckBox(String checkBox1, String checkBox2) {
        checkBoxes.findBy(text(checkBox1)).click();
        checkBoxes.findBy(text(checkBox2)).click();
    }

    @When("I unselect checkboxes " + regex + " and " + regex)
    public void unselectCheckBox(String checkBox1, String checkBox2) {
        checkBoxes.findBy(text(checkBox1)).click();
        checkBoxes.findBy(text(checkBox2)).click();
    }

    @When("I select radiobutton " + regex)
    public void selectRadioButton(String button) {
        radioButtons.find(text(button)).click();
    }

    @When("I select dropdown " + regex)
    public void selectInDropDown(String option) {
        dropDown.click();
        dropDown.selectOption(option);

    }

    //================================checks===================================

    @Then(regex + " Page should be opened")
    public void checkBrowserTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @And("There is right section")
    public void checkRightSectionExist() {
        rightSection.shouldBe(visible);
    }

    @And("There is left section")
    public void checkLeftSectionExist() {
        leftSection.shouldBe(visible);
    }

    @Then("Log should have checkboxes " + regex + " and " + regex + " " + regex)
    public void checkLogCheckBox(String checkBox1, String checkBox2, String selected) {
        List<String> checkB = new ArrayList<>();
        checkB.add(checkBox2);
        checkB.add(checkBox1);
        int countCheckBox = 0;
        for (String checkBox : checkB) {
            checkLog(logRecords.get(countCheckBox).getText(), checkBox, selected.equals("selected") ? "true" : "false");
            countCheckBox++;
        }
    }

    @Then("Log should have radio " + regex + " selected")
    public void checkLogRadio(String radioButton) {
        checkLog(logRecords.first().getText(), RadioButtons.getCategory(), radioButton);
    }

    @Then("Log should have dropdown " + regex + " selected")
    public void checkLogDropDown(String color) {
        checkLog(logRecords.first().getText(), Colors.getCategory(), color);
    }

    private void checkLog(String log, String value, String condition) {
        assertTrue(log.contains(value));
        assertTrue(log.contains(condition));
    }

    @And("The following elements is displayed: (\\d+) checkboxes, (\\d+) radios, dropdown, (\\d+) buttons")
    public void pageElementsExist(int checkCount, int radioCount, int buttonCount) {
        checkCheckboxesExist(checkCount);
        checkRadiosExist(radioCount);
        assertEquals(buttonCount, 2);
        checkDropdownExist();
        checkButtonsExist();
    }

    private void checkCheckboxesExist(int count) {
        checkBoxes.shouldHaveSize(count);
        for (SelenideElement box : checkBoxes) {
            box.shouldBe(visible);
        }
    }

    private void checkRadiosExist(int count) {
        radioButtons.shouldHaveSize(count);
        for (SelenideElement radio : radioButtons) {
            radio.shouldBe(visible);
        }
    }

    private void checkDropdownExist() {
        dropDown.shouldBe(visible);
    }
    
    private void checkButtonsExist() {
        button.shouldBe(visible);
        defaultButton.shouldBe(visible);
    }
}

