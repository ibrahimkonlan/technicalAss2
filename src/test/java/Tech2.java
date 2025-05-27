import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.AbstractXmlReporter;

import static com.sun.org.apache.bcel.internal.util.Args.require;
import static jdk.jpackage.internal.WixAppImageFragmentBuilder.Component.File;

public class Tech2 {
    private WebDriver driver;

   public void sauceDemo() {
       ;
   }
//const { Builder, By } = require('selenium-webdriver');
const fs = require('fs');
const path = require('path');

    function uploadFile() {
        let driver = new AbstractXmlReporter.Count.Builder().forBrowser('firefox').build();
        driver.get('https://the-internet.herokuapp.com/upload');

        let filePath = path.join(__dirname, 'test_upload.txt');
        fs.writeFileSync(filePath, 'This is a test file.');

        driver.findElement(By.id('file-upload')).sendKeys(filePath);
        driver.findElement(By.id('file-submit')).click();

        driver.findElement(By.id('uploaded-files')).getText().then(function(uploadedFileName) {
            console.log(Uploaded File: ${uploadedFileName});
            fs.unlinkSync(filePath); // Clean up the test file
            driver.quit();
        }
    }

}
