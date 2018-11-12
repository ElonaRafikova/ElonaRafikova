package hw8.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import hw8.dataProviders.MetalAndColorsTemplate;
import hw8.site.sections.MetalAndColorsForm;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    public MetalAndColorsForm metalAndColorsForm;

    @FindBy(css = ".panel-body-list.results> li")
    private TextList results;

    public void checkFilled(MetalAndColorsTemplate data) {
        assertEquals(results.getTextList(), data.asResult());
    }
}

