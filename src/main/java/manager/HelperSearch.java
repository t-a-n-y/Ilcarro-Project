package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        clearPeriod();
        click(By.id("dates"));
                                                     //  0   1     2
        String [] from = dataFrom.split("/");  // ["7"],["25"],["2022"],    from[1] = "25"
        String locator = "//div[text()=' " + from[1]+" ']";
        click(By.xpath(locator));


        String [] to = dataTo.split("/");
        String locator2 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    private void clearPeriod() {
        WebElement el = wd.findElement(By.cssSelector("#dates"));
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        if(osName.startsWith("Mac")){
            el.sendKeys(Keys.COMMAND, "a");
        }else {
            el.sendKeys(Keys.CONTROL, "a");
        }
        el.sendKeys(Keys.DELETE);
    }

    private void typeCity(String city) {
        type(By.cssSelector("#city"),city);
        pause(2000);
        click(By.cssSelector(".pac-item"));

    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodCurrentYear(dataFrom, dataTo);
    }

    private void selectPeriodCurrentYear(String dataFrom, String dataTo) {
        //      8/10/2022             10/20/2022
        clearPeriod();
        String dataNow = "7/20/2022";
        String [] now = dataNow.split("/");
        String [] from = dataFrom.split("/");
        String[] to = dataTo.split("/");

        click(By.id("dates"));

        if(Integer.parseInt(now[0])!=Integer.parseInt(from[0])){
            int diffMonth = Integer.parseInt(from[0]) - Integer.parseInt(now[0]);
            clickNextMonth(diffMonth);
        }
        String locator = String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));


        if(Integer.parseInt(from[0])!=Integer.parseInt(to[0])){
            int diffMonth2 = Integer.parseInt(to[0]) - Integer.parseInt(from[0]);
            clickNextMonth(diffMonth2);
        }

        String locator2 = String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));

    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("[aria-label='Next month']"));
        }
    }

    public boolean isListOfCarsAppeared() {
       return wd.findElements(By.cssSelector(".car-img-container.ng-star-inserted")).size()>0;

    }

    public void returnToHome() {
        click(By.cssSelector(".logo"));
    }

    public void searchCurrentYearLocalData(String city, String dataFrom, String dataTo) {
       typeCity(city);
       pause(2000);
       clearPeriod();
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));

        if(now.getMonthValue()!=from.getMonthValue()){
            int diffMonth = from.getMonthValue() - now.getMonthValue();
            clickNextMonth(diffMonth);
        }
        String locator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(locator));

        if(from.getMonthValue()!=to.getMonthValue()){
            int diffMonth = to.getMonthValue() - from.getMonthValue();
            clickNextMonth(diffMonth);
        }
        locator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(locator));

    }

    public void searchAnyPeriodLocalDate(String city, String dataFrom, String dataTo) {
       pause(2000);
        typeCity(city);
        pause(2000);
        clearPeriod();
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));
        // "8/10/2022", "3/20/2023"
        int diffYear;
        int diffMonth;

        diffYear=from.getYear()-now.getYear();
        if(diffYear==0){
            diffMonth= from.getMonthValue()-now.getMonthValue(); /// 8-7 =1
        }else {
            diffMonth= 12-now.getMonthValue()+from.getMonthValue(); //12-7+3
        }
        clickNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        ///**************
        diffYear=to.getYear()-from.getYear();

        if(diffYear==0){
            diffMonth = to.getMonthValue()-from.getMonthValue();
        }else {
            diffMonth= 12-from.getMonthValue()+to.getMonthValue();
        }
        clickNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    public void searchAnyPeriodLocalDate2(String city, String dataFrom, String dataTo) {
        typeCity(city);
        LocalDate now = LocalDate.now();
        LocalDate from= LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
        click(By.id("dates"));

        int diffMonth = from.getYear()-now.getYear()
                ==0 ? from.getMonthValue() -now.getMonthValue() : 12-now.getMonthValue()+ from.getMonthValue();

        clickNextMonth(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));

        diffMonth= to.getYear()-from.getYear()
                ==0  ?to.getMonthValue()-from.getMonthValue(): 12-from.getMonthValue()+to.getMonthValue();

        clickNextMonth(diffMonth);
        locator=String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
    }

    public void searchPeriodPast(String city, String dataFrom, String dataTo) {

        typeCity(city);
        pause(2000);
        typePeriodInPast(dataFrom, dataTo);

    }

    private void typePeriodInPast(String dataFrom, String dataTo) {
        clearPeriod();
        wd.findElement(By.cssSelector("#dates"));
        type(By.cssSelector("#dates"), dataFrom + "-" + dataTo);
        click(By.cssSelector(".cdk-overlay-container"));



    }

    public boolean isPeriodInPast() {
        pause(1000);
        WebElement el = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String error = el.getText();
        System.out.println(error);
        return error.equals("You can't pick date before today");
    }
}
