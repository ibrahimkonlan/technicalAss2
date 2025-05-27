import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.AbstractXmlReporter;

public class TechAssessment {
    private WebDriver driver;
//    const { Builder, By } = require('selenium-webdriver');

    public void addEmployee() {
//        let driver = new AbstractXmlReporter.Count.Builder().forBrowser('firefox').build();
        driver.get('https://demoqa.com/webtables');
        driver.findElement(By.id('addNewRecordButton')).click();
        driver.findElement(By.id('firstName')).sendKeys('Auto');
        driver.findElement(By.id('lastName')).sendKeys('User');
        driver.findElement(By.id('userEmail')).sendKeys('auto.user@example.com');
        driver.findElement(By.id('age')).sendKeys('30');
        driver.findElement(By.id('salary')).sendKeys('50000');
        driver.findElement(By.id('department')).sendKeys('QA');
        driver.findElement(By.id('submit')).click();

        driver.findElements(By.css('.rt-tr-group')).then(function(rows) {
            let addedEmployee = rows[rows.length - 1];
            addedEmployee.findElement(By.css('.rt-td:nth-child(1)')).getText().then(function(firstName) {
                addedEmployee.findElement(By.css('.rt-td:nth-child(2)')).getText().then(function(lastName) {
                    addedEmployee.findElement(By.css('.rt-td:nth-child(4)')).getText().then(function(email) {
                        console.log(Added Employee: ${firstName} ${lastName}, Email: ${email});
                        driver.quit();
                    }
                }
            }

