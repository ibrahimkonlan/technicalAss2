import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUploadTest {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Create dummy file
        File file = new File("test_upload.txt");
        FileWriter writer = new FileWriter(file);
        writer.write("This is a test file.");
        writer.close();

        driver.get("https://the-internet.herokuapp.com/upload");

        // Upload file
        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        uploadInput.sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("file-submit")).click();

        // Verify upload
        WebElement uploadedMessage = driver.findElement(By.id("uploaded-files"));
        if (uploadedMessage.getText().equals("test_upload.txt")) {
            System.out.println(":white_check_mark: File uploaded successfully.");
        } else {
            System.out.println(":x: Upload failed.");
        }

        // Clean up file
        file.delete();

        driver.quit();
    }
}