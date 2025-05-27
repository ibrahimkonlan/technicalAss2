import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add item to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Proceed to checkout
        driver.findElement(By.id("checkout")).click();

        // Fill in info
        driver.findElement(By.id("first-name")).sendKeys("Auto");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.id("continue")).click();

        // Finish order
        driver.findElement(By.id("finish")).click();

        // Confirm order
        WebElement message = driver.findElement(By.className("complete-header"));
        if (message.getText().contains("THANK YOU")) {
            System.out.println(":white_check_mark: Order placed successfully.");
        } else {
            System.out.println(":x: Order failed.");
        }

        driver.quit();
    }
}