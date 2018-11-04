package hw8.entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass {

    public static User PITER_CHALOVSKII = new User("epam", "1234");

    String name;
    String password;
}
