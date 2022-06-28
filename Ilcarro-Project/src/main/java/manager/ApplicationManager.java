package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = new UserHelper(wd);

    }

    public void stop(){
        wd.close();
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}
