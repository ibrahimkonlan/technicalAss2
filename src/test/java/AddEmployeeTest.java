import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class AddEmployeeTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/webtables");

        // Click "Add" button
        driver.findElement(By.id("addNewRecordButton")).click();

        // Fill out the form
        driver.findElement(By.id("firstName")).sendKeys("Auto");
        driver.findElement(By.id("lastName")).sendKeys("User");
        driver.findElement(By.id("userEmail")).sendKeys("auto.user@example.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("50000");
        driver.findElement(By.id("department")).sendKeys("QA");

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Verify the employee appears in table
        List<WebElement> rows = driver.findElements(By.className("rt-tr-group"));
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains("Auto") && row.getText().contains("User") && row.getText().contains("auto.user@example.com")) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(":white_check_mark: Employee added successfully.");
        } else {
            System.out.println(":x: Employee not found.");
        }

        driver.quit();
    }
}