package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");


    }
    @Test(dataProvider = "dataRegistration", dataProviderClass = MyDataProvider.class)
    public void registrationSuccess2(User user){

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(2000);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        app.getHelperUser().pause(2000);
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");

    }

    @Test
    public void registrationWrongPasswordFormatSize(){

        User user = new User().setName("Zoa").setLastName("DSnow").setEmail("zoa@gmail.com").setPassword("Zoa");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOk();
    }
}
