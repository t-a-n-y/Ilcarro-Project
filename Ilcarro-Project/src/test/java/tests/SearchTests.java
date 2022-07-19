package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCurrentMonth(){
        app.search().searchCurrentMonth("Tel Aviv", "7/27/2022", "7/28/2022");
        app.search().submit();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYear(){
        app.search().searchCurrentYear("Tel Aviv", "08/10/2022", "09/23/2022");
        app.search().submit();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }


}
