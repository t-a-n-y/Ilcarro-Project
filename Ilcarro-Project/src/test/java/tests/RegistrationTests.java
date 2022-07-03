package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }



    @Test
    public void registrationSuccess(){
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Lis").setLastName("Snow").setEmail("fox"+i+"@mail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getMessage(),"Registered");
        app.getHelperUser().clickOk();

    }
    @Test
    public void registrationSuccess2(){
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Lis").setLastName("Snow").setEmail("fox"+i+"@mail.com").setPassword("Ff12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

    }
}
