package pageObjects.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxes;
import enums.Colors;
import enums.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageAllure {

    private final String differentElementsPageBrowserTitle = "Different Elements";

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


    //================================methods===================================
    @Step
    public void selectCheckBox(CheckBoxes... inputCheckBoxes) {

        for (CheckBoxes inputCheckBox : inputCheckBoxes) {
            checkBoxes.find(Condition.text(inputCheckBox.getTitle())).click();
        }

    }

    @Step
    public void selectRadioButton(RadioButtons button) {
        radioButtons.find(Condition.text(button.getTitle())).click();

    }

    @Step
    public void selectInDropDown(Colors option) {
        dropDown.click();
        dropDown.selectOption(option.getTitle());

    }

    //================================checks===================================

    @Step
    public void checkBrowserTitle() {
        assertEquals(getWebDriver().getTitle(), differentElementsPageBrowserTitle);
    }

    @Step
    private void checkCheckboxesExist() {
        for (SelenideElement box : checkBoxes) {
            box.shouldBe(Condition.visible);
        }
    }

    @Step
    private void checkRadiosExist() {
        for (SelenideElement radio : radioButtons) {
            radio.shouldBe(Condition.visible);
        }
    }

    @Step
    private void checkDropdownExist() {
        dropDown.shouldBe(Condition.visible);
    }

    @Step
    private void checkButtonsExist() {
        button.shouldBe(Condition.visible);
        defaultButton.shouldBe(Condition.visible);
    }

    @Step
    public void checkRightSectionExist() {
        rightSection.shouldBe(Condition.visible);
    }

    @Step
    public void checkLeftSectionExist() {
        leftSection.shouldBe(Condition.visible);
    }

    @Step
    public void checkCheckBoxChecked(boolean b, CheckBoxes... options) {
        for (CheckBoxes option : options) {
            SelenideElement o1 = checkBoxes.find(Condition.text(option.getTitle())).$("input");
            assertEquals(b, o1.isSelected());
        }
    }

    @Step
    public void checkRadioButtonChecked(boolean b, RadioButtons option) {
        assertEquals(b, radioButtons.find(Condition.text(option.getTitle())).$("input").isSelected());
    }

    @Step
    public void checkDropDownSelected(boolean b, Colors option) {
        assertEquals(b, dropDown.getSelectedOption().is(Condition.text(option.getTitle())));
    }

    @Step
    public void checkLogCheckBox(boolean b, CheckBoxes... checkBoxes) {
        Collections.reverse(Arrays.asList(checkBoxes));
        int countCheckBox = 0;
        for (CheckBoxes checkBox : checkBoxes) {
            checkLog(logRecords.get(countCheckBox).getText(), checkBox.getTitle(), String.valueOf(b));
            countCheckBox++;
        }
    }

    @Step
    private void checkLog(String log, String value, String condition) {
        assertTrue(log.contains(value));
        assertTrue(log.contains(condition));
    }

    @Step
    public void checkLogRadio(RadioButtons radioButton) {
        checkLog(logRecords.first().getText(), RadioButtons.getCategory(), radioButton.getTitle());
    }

    @Step
    public void checkLogDropDown(boolean b, Colors color) {
        checkLog(logRecords.first().getText(), Colors.getCategory(), color.getTitle());
    }

    @Step
    public void pageElementsExist() {
        checkCheckboxesExist();
        checkRadiosExist();
        checkDropdownExist();
        checkButtonsExist();
    }
}

