/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;
    WebDriver driver;
    
    public AbstractPage(WebDriver driver){
        this.driver  = driver;
        PageFactory.initElements(this.driver, this);
    }
    
    protected WebDriver getDriver(){
        return this.driver;
    }
    
  private boolean isElementPresent(By locator){
       return !driver.findElements(locator).isEmpty();
  }
  
  public void waitForElementPresent(By locator){
      new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  };
  
  protected void highlightElement(By locator){
      ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", driver.findElement(locator));
  }
  
  protected void unhighlightElement(By locator){
      ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
  }
 
  //public void waitForElementVisible(By locator){
    //  new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  //}
  
    //public void waitForElementEnabled(By locator){
      //new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
  //}
  
}
