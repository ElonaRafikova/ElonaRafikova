package hw5;

import base.SelenideTestBase;
import enums.HeaderSections;
import enums.LeftSections;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw5.DifferentElementsPageAllure;
import pageObjects.hw5.HomePageAllure;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.Colors.RED;
import static enums.Colors.YELLOW;
import static enums.RadioButtons.SELEN;
import static enums.ServiceDropDowns.DIFFERENT_ELEMENTS;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("DifferentElements Page Testing")
@Listeners(AllureAttachmentListener.class)

public class ServicePageTestAllure extends SelenideTestBase {
    private HomePageAllure homePage;
    private DifferentElementsPageAllure differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageAllure.class);
        differentElementsPage = page(DifferentElementsPageAllure.class);
    }

    @Flaky
    @Test
    public void servicePageInterfaceTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkBrowserTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkUserName(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.clickOnHeader(HeaderSections.SERVICE);
        homePage.checkHeaderServiceDropDown();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.clickOnLeftSection(LeftSections.SERVICE);
        homePage.checkLeftServiceDropDown();

        //7 Open through the header menu Service -> Different Elements Page
        homePage.clickOnHeader(HeaderSections.SERVICE);
        homePage.chooseServiceOption(DIFFERENT_ELEMENTS);
        differentElementsPage.checkBrowserTitle();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.pageElementsExist();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionExist();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionExist();

        //11 Select checkboxes
        differentElementsPage.selectCheckBox(WATER, WIND);
        differentElementsPage.checkCheckBoxChecked(true, WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogCheckBox(true, WATER, WIND);

        //13 Select radio
        differentElementsPage.selectRadioButton(SELEN);
        differentElementsPage.checkRadioButtonChecked(true, SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogRadio(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectInDropDown(YELLOW);
        differentElementsPage.checkDropDownSelected(true, YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.checkLogDropDown(true, RED);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckBox(WATER, WIND);
        differentElementsPage.checkCheckBoxChecked(false, WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogCheckBox(false, WATER, WIND);
    }

}


