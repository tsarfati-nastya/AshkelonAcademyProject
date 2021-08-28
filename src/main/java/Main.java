import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anast\\Downloads\\chromedriver_win32 (1)");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
    }
}
