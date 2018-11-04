package hw8.site.pages;

import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw8.dataProviders.MetalAndColorsTemplate;
import hw8.site.sections.Summary;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    @FindBy(id = "summary-block")
    private Summary summary;

    @FindBy(css = ".panel-body-list.results> li")
    private TextList results;

    @FindBy(id = "submit-button")
    private Button submitButton;

    @FindBy(css = "#elements-checklist p")
    private ICheckList nature;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option")
    )
    private IDropDown colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"),
            jexpand = @JFindBy(css = ".caret")
    )
    private IDropDown metals;

    @JDropdown(
            jroot = @JFindBy(id = "salad-dropdown"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(tagName = "button")

    )
    private IDropDown vegetables;

    public void fill(MetalAndColorsTemplate data) {
        fillSummary(data.getSummary());
        fillElements(data.getElements());
        colors.select(data.getColor());
        metals.select(data.getMetals());
        fillVegetables(data.getVegetables());
    }

    private void fillVegetables(String[] dataVegetables) {
        vegetables.select("Vegetables");
        for (String s : dataVegetables) {
            vegetables.select(s);
        }
    }

    private void fillElements(String[] dataElements) {
        for (String element : dataElements) {
            nature.select(element);

        }
    }

    private void fillSummary(int[] dataSummary) {
        for (int i : dataSummary) {
            summary.select(i);
        }
    }

    public void checkFilled(MetalAndColorsTemplate data) {
        assertEquals(results.getTextList(), data.asResult());
    }

    public void submit() {
        submitButton.click();
    }
}

