package tests;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests{

    @Test
    public void successLogin(){
        openLoginForm();
        fillLoginForm("tanya@gmail.ru","Ttanya123$");
        submitYalla();
        //Assert

    }

    @Test
    public void loginNegativeTestWrongLogin(){
        openLoginForm();
        fillLoginForm("tanyagmail.ru","Ttanya123$");
        submitYalla();
        //Assert

    }















}
