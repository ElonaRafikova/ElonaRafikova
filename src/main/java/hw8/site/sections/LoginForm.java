package hw8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import hw8.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(css = "#Name")
    private TextField name;

    @FindBy(css = "#Password")
    private TextField password;

    @FindBy(css = "form [type=submit]")
    private Button submit;
}
