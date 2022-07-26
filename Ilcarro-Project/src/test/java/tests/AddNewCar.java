package tests;

import manager.MyDataProvider;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends TestBase{

    @BeforeMethod
    public void preCondition(){
   if(!app.getHelperUser().isLogged()){
       app.getHelperUser().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));

   }
    }

    @Test(dataProvider = "dataAddNewCar", dataProviderClass = MyDataProvider.class)
    public void addNewCarSuccsess(Car car){

        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\auto1.jpeg");
        app.car().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Car added");
    }
    @AfterMethod
    public void postCondition(){
        app.car().returnHome();

    }
}
