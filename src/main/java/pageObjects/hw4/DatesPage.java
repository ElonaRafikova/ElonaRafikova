package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Double.parseDouble;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatesPage {

    private final String differentElementsPageBrowserTitle = "Dates";

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection sliders;

    @FindBy(css = "div.ui-widget-content")
    private SelenideElement slider;

    @FindBy(css = ".panel-body-list.logs> li")
    private ElementsCollection logRecords;

    private boolean fromActive = true;
    private final int STEPS = 100;
    private final int MIN_STEP = 0;
    private final int MAX_STEP = 100;


    //================================methods===================================

    private Double getStep() {
        return (double) slider.getSize().width;
    }

    private Double getCurrentPosition(int slider) {
        return parseDouble(sliders.get(slider).getCssValue("left")
                .replaceAll("px", "")) / (getStep() / (STEPS - 1)) + 1;

    }

    @Step
    public void setDragAndDropSliders(int fromNew, int toNew) {
        assertTrue(fromNew >= MIN_STEP && toNew <= MAX_STEP);
        assertTrue(fromNew >= MIN_STEP && toNew <= MAX_STEP);
        assertTrue(fromNew <= toNew);

        Double currentFrom = getCurrentPosition(0);
        Double currentTo = getCurrentPosition(1);

        if (!currentFrom.equals(currentTo)) {
            if (fromNew > currentTo) {
                setPosition(toNew, sliders.get(1), currentTo);
                setPosition(fromNew, sliders.get(0), currentFrom);
                fromActive = true;
            } else {
                setPosition(fromNew, sliders.get(0), currentFrom);
                setPosition(toNew, sliders.get(1), currentTo);
                fromActive = false;

            }
        } else {
            SelenideElement activeElement = sliders.find(Condition.focused);
            SelenideElement nonActiveElement = sliders.find(Condition.not(Condition.focused));
            if (fromNew < currentFrom) {
                setPosition(fromNew, activeElement, currentFrom);
                setPosition(toNew, nonActiveElement, currentTo);
                fromActive = false;

            } else {
                setPosition(toNew, activeElement, currentTo);
                setPosition(fromNew, nonActiveElement, currentFrom);
                fromActive = true;
            }

        }

    }

    private void setPosition(Integer position, SelenideElement slider, Double currentPosition) {
        int xOffset = (int) ((position - currentPosition) * (getStep() / (STEPS - 1)));
        Actions action = new Actions(getWebDriver());
        action.dragAndDropBy(slider, xOffset, 0).build().perform();
    }

    //================================checks===================================

    @Step
    public void checkBrowserTitle() {
        assertEquals(getWebDriver().getTitle(), differentElementsPageBrowserTitle);
    }

    @Step
    public void checkLog(int from, int to) {

        ElementsCollection neededRecords = logRecords.first(2);
        if (fromActive) {
            checkLogRecord(neededRecords.first().getText(), from, "From");
            checkLogRecord(neededRecords.last().getText(), to, "To");

        } else {
            checkLogRecord(neededRecords.last().getText(), from, "From");
            checkLogRecord(neededRecords.first().getText(), to, "To");
        }
    }

    private void checkLogRecord(String needed, int position, String category) {
        assertTrue(needed.contains(String.valueOf(position)));
        assertTrue(needed.contains(category));
    }
}
