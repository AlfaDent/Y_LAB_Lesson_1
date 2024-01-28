import org.example.controllers.AuthenticationController;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticationControllerTest {

    @Test
    public void testAuthUser_SuccessfullyAuthenticated() {
        ArrayList<User> userList = new ArrayList<>();
        User existingUser = new User("john", "password");
        userList.add(existingUser);

        AuthenticationController authenticationController = new AuthenticationController();

        User authenticatedUser = authenticationController.authUser(userList, "john", "password");

        assertThat(authenticatedUser).isEqualTo(existingUser);
    }

    @Test
    public void testAuthUser_UnknownUser() {
        ArrayList<User> userList = new ArrayList<>();
        AuthenticationController authenticationController = new AuthenticationController();
        userList.add(new User("john", "password"));

        User authenticatedUser = authenticationController.authUser(userList, "unknownUser", "password");

        assertThat(authenticatedUser).isNull();
    }

    @Test
    public void testAuthUser_EmptyUserList() {
        ArrayList<User> userList = new ArrayList<>();
        AuthenticationController authenticationController = new AuthenticationController();

        User authenticatedUser = authenticationController.authUser(userList, "john", "password");

        assertThat(authenticatedUser).isNull();
    }

    @Test
    public void testRegisterUser_SuccessfullyRegistered() {
        ArrayList<User> userList = new ArrayList<>();
        AuthenticationController authenticationController = new AuthenticationController();

        User registeredUser = authenticationController.registerUser(userList, "newUser", "password");

        assertThat(registeredUser).isNotNull();
        assertThat(userList).contains(registeredUser);
    }

    @Test
    public void testRegisterUser_DuplicateUser() {
        ArrayList<User> userList = new ArrayList<>();
        User existingUser = new User("john", "password");
        userList.add(existingUser);

        AuthenticationController authenticationController = new AuthenticationController();

        User registeredUser = authenticationController.registerUser(userList, "john", "password");

        assertThat(registeredUser).isNull();
    }
}