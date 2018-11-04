package hw8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {

    @FindBy(css = "#odds-selector p")
    private RadioButtons oddsR;

    @FindBy(css = "#even-selector p")
    private RadioButtons evenR;

    public void select(int value) {
        if (value % 2 == 0) {
            evenR.select(String.valueOf(value));
        } else {
            oddsR.select(String.valueOf(value));
        }
    }

}
