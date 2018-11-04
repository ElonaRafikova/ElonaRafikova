package hw8;

import hw8.base.TestBase;
import hw8.dataProviders.MetalAndColorsDataProviders;
import hw8.dataProviders.MetalAndColorsTemplate;
import hw8.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static hw8.enums.MenuOptions.METALS_AND_COLORS;
import static hw8.site.Site.homePage;
import static hw8.site.Site.metalAndColorsPage;


public class MetalAndColorsTest extends TestBase {

    @AfterMethod()
    public void afterMethod() {
        homePage.clearCache();
    }

    @Test(dataProvider = "metalAndColorsDataProvider", dataProviderClass = MetalAndColorsDataProviders.class)
    public void metalAndColorTest(MetalAndColorsTemplate data) {

        //1 Login on JDI site as User
        homePage.open();
        homePage.login(User.PITER_CHALOVSKII);
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        homePage.navigation.select(METALS_AND_COLORS);
        metalAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data
        metalAndColorsPage.fill(data);

        //Submit form Metals & Colors
        metalAndColorsPage.submit();

        //4 Result sections should contains data
        metalAndColorsPage.checkFilled(data);


    }
}
