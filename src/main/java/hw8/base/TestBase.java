package hw8.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw8.site.Site;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class TestBase extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {

        WebSite.init(Site.class);
        logger.info("Run Tests");
    }
}
