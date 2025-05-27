import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tech3 {

   public void addEmployee() {
       ;
       WebDriver driver;
//const { Builder, By } = require('selenium-webdriver');
   }
//     public v sauceDemo() {
        let driver = new Builder().forBrowser('firefox').build();
        driver.get('https://www.saucedemo.com/');
        driver.findElement(By.id('user-name')).sendKeys('standard_user');
        driver.findElement(By.id('password')).sendKeys('secret_sauce');
        driver.findElement(By.id('login-button')).click();

        driver.findElement(By.css('.inventory_item:nth-child(1) .btn_inventory')).click();
        driver.findElement(By.css('.shopping_cart_link')).click();
        driver.findElement(By.id('checkout')).click();

        driver.findElement(By.id('first-name')).sendKeys('Auto');
        driver.findElement(By.id('last-name')).sendKeys('User');
        driver.findElement(By.id('postal-code')).sendKeys('12345');
        driver.findElement(By.id('continue')).click();
        driver.findElement(By.id('finish')).click();

        driver.findElement(By.css('.complete-header')).getText().then(function(confirmation) {
            console.log(Order Confirmation: ${confirmation});
            driver.quit();
        });
    }

}

