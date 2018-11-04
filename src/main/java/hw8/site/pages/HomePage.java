package hw8.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import hw8.entities.User;
import hw8.enums.MenuOptions;
import hw8.site.sections.LoginForm;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.html", title = "Home Page")
public class HomePage extends WebPage {

    @FindBy(css = ".nav>li>a")
    public Menu<MenuOptions> navigation;

    private LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    private Button profilePhoto;

    public void login(User user) {
        profilePhoto.click();
        loginForm.login(user);
    }
}
