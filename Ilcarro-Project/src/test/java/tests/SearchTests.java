package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCurrentMonth(){
        app.search().searchCurrentMonth("Tel Aviv", "7/27/2022", "7/28/2022");
        app.search().submit();
      //  app.getHelperUser().pause(5000);

        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takescreenShots("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\src\\test\\screenshots/screen1.png");

    }

    @Test
    public void searchPeriodPast(){
        app.search().searchPeriodPast("Haifa", "5/10/22", "6/20/22");
        app.search().submit2();

        Assert.assertFalse(app.getHelperUser().isYallaButtonNotClicable());
        Assert.assertTrue(app.search().isPeriodInPast());
        app.search().takescreenShots("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\src\\test\\screenshots/screen2.png");

    }

    @Test
    public void searchCurrentYear(){

        app.search().searchCurrentYear("Jerusalem", "8/10/2022", "10/23/2022");
        app.search().submit();
       // app.getHelperUser().pause(5000);

        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takescreenShots("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\src\\test\\screenshots/screen3.png");
    }

    @Test
    public void searchCurrentYearLocalDate(){
        app.search().searchCurrentYearLocalData("Haifa", "08/10/2022", "10/23/2022");
        app.search().submit();
       // app.getHelperUser().pause(5000);

        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takescreenShots("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\src\\test\\screenshots/screen4.png");

    }
    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriodLocalDate("Haifa", "8/10/2022", "3/20/2023");
        app.search().submit();
        //app.getHelperUser().pause(5000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takescreenShots("C:\\Git\\Ilcarro-Project\\Ilcarro-Project\\src\\test\\screenshots/screen5.png");
    }


    @AfterMethod()
    public void returnToHome(){
        app.search().returnToHome();
    }


}
