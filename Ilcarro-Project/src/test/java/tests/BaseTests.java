package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void openLoginForm(){
        wd.findElement(By.cssSelector("a[href^='/login']")).click();

    }

    public void fillLoginForm(String email, String password){
        //find+click+clear+sendKey
        type(By.cssSelector("#email"),email);

        //find+click+clear+sendKey
        type(By.cssSelector("#password"),password);
    }

    public void submitYalla(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void type(By locator, String text){
        if(text!=null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
}
