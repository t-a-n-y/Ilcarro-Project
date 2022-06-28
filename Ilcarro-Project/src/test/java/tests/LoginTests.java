package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void successLogin() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("tanya@gmail.ru", "Ttanya123$");
        app.getUser().submitYalla();
        //Assert

    }

}
