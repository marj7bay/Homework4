/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;

import PageObject.AbstractPage;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddProductPage extends AbstractPage {
   // WebDriver driver;
    private static final By PRODUCT_NAME_FIELD = By.cssSelector("#id_product_name");
    private static final By LINK_FIELD = By.xpath("//*[@id=\"id_link\"]");
    private static final By DESCRIPTION_FIELD = By.xpath("//*[@id=\"id_description\"]");
    
   
    
    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div/ul/li[3]/a")         
    WebElement addProductButton;
   
    @FindBy(css = "#product_form > div > div > div > div.form-actions > button")
            WebElement saveChangesButton;

    public AddProductPage(WebDriver driver){
        super(driver);
    }
    
    public AddProductPage addProduct(){
      //waitForElementPresent(QUERY_DETAILS_LOCATOR);
      //  waitForElementPresent(SUCCESS_LOCATOR);
       // return driver.findElement(QUERY_DETAILS_LOCATOR).getText();
     //String priceTextValue = itemPrice.getText();
    // return Double.parseDouble(priceTextValue.substring(1));
        
     new Actions(driver).click(addProductButton).build().perform();
     WebElement productName = driver.findElement(PRODUCT_NAME_FIELD);
     new Actions(driver).sendKeys(productName, "test1").perform();
     WebElement productLink = driver.findElement(LINK_FIELD);
     new Actions(driver).sendKeys(productLink, "test1").perform();
     WebElement productDescription = driver.findElement(DESCRIPTION_FIELD);
     new Actions(driver).sendKeys(productDescription, "test1").perform();
     new Actions(driver).click(saveChangesButton).build().perform();
     //String querycontent = successLabel.getText();
     //Assert.assertEquals(querycontent, "SUCCESS");
     return new AddProductPage(getDriver());
   //  Assert.assertEquals(actualStr, expectedStr);
    }
    
//    public AddProductPage runQuery(){
//     getDriver().get("https://console-development.treasuredata.com/app/queries");
//     new Actions(driver).click(queryRunButton).build().perform();
//     String querycontent = queryInputField.getText();
//     Assert.assertEquals("select 'test@test.com' as email, 'Maryana6' as fname, 'B6' as lname", querycontent);
//     return new AddProductPage(getDriver());
//    }
}

