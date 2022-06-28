package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
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

    public boolean isLogged() {
        //sign out present---->logged
        List<WebElement> list = wd.findElements(By.cssSelector("a[href^='/logout']"));
        return list.size()>0;

    }

    public void logOut() {

        click(By.cssSelector("a[href^='/logout']"));

    }
}
