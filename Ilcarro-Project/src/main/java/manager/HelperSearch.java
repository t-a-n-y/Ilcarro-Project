package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentMonth(dataFrom, dataTo);

    }

    private void selectPeriodCurrentMonth(String dataFrom, String dataTo) {
        //     7/25/2022",       "7/30/2022
        click(By.id("dates"));
                                                     //  0   1     2
        String [] from = dataFrom.split("/");  // ["7"],["25"],["2022"],    from[1] = "25"
        String locator = "//div[text()=' " + from[1]+" ']";
        click(By.xpath(locator));


        String [] to = dataTo.split("/");
        String locator2 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector(".pac-item"));
        pause(1000);
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom, dataTo);
    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        //      8/10/2022             10/20/2022
        String dataNow = "7/20/2022";
        String [] now = dataNow.split("/");
        click(By.id("dates"));
        String [] from = dataFrom.split("/");
        String[] to = dataTo.split("/");
        int diffMonth = Integer.parseInt(from[0]) - Integer.parseInt(now[0]);
        if(diffMonth != 0){
            clickNextMonth(diffMonth);
            String locator = String.format("//div[text()=' %s ']",from[1]);
            click(By.xpath(locator));
        }
        else{
            String locator = String.format("//div[text()=' %s ']",from[1]);
            click(By.xpath(locator));
        }
        int diffMonth2 = Integer.parseInt(to[0]) - Integer.parseInt(from[0]);
        if(diffMonth2 != 0){
            clickNextMonth(diffMonth);
            String locator = String.format("//div[text()=' %s ']",to[1]);
            click(By.xpath(locator));
        }
        else{
            String locator = String.format("//div[text()=' %s ']",to[1]);
            click(By.xpath(locator));
        }
    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("[aria-label='Next month']"));
        }
    }

    public boolean isListOfCarsAppeared() {
       return wd.findElements(By.cssSelector(".car-img-container.ng-star-inserted")).size()>0;

    }
}
