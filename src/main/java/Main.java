import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        Scanner scanner = new Scanner(System.in);
        System.out.println("pleas enter your user name");
        String userName = scanner.next();
        System.out.println("pleas enter your password");
        String password = scanner.next();
        WebDriver driver = new ChromeDriver();
        driver.get(DataText.CUMPUS_URL);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(DataText.PORTAL_URL)).click();
        driver.findElement(By.cssSelector(DataText.USER_NAME_URL)).sendKeys(userName);
        driver.findElement(By.cssSelector(DataText.PASSWORD_URL)).sendKeys(password);
        driver.findElement(By.cssSelector(DataText.SUBMIT_URL)).click();
        driver.findElement(By.cssSelector(DataText.LOGIN_URL)).click();
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DataText.COURSE_NAME_URL)));
        List<WebElement> courseList = driver.findElements(By.cssSelector(DataText.COURSE_NAME_URL));
        for (int i = 0; i < courseList.size(); i++) {
            System.out.print(i+1 + ") ");
            String text = courseList.get(i).getText();
           text = text.replace("שם הקורס","").trim();
            System.out.println(text);
        }
        System.out.println("pleas enter the course number");
        int choice = scanner.nextInt();
        courseList.get(choice -1).click();
        driver.findElement(By.cssSelector(DataText.MENU_URL)).click();
        driver.findElement(By.cssSelector(DataText.LOGOUT_URL)).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DataText.PORTAL_LOGOUT_URL)));
        driver.findElement(By.cssSelector(DataText.PORTAL_LOGOUT_URL)).click();

    }
}
