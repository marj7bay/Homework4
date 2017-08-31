/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObject;
import BusinessObject.User;
import PageObject.AddProductPage;
import PageObject.AbstractPage;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.MalformedURLException;
import java.net.URL;

public class MainPage extends AbstractPage {
 //   WebDriver driver;
  //  private static final By SEARCH_INPUT_LOCATOR = By.cssSelector("#test");
   // private static final By GO_BUTTON_LOCATOR = By.xpath("#test");
    private static final By LOGIN_TEXTFIELD_LOCATOR = By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[1]/input");
  //  private static final By QUERY_ICON = By.xpath("//*[@id=\"SIDEMENU_QUERIES\"]/span");
    private static final By QUERIES_LIST = By.cssSelector("#app > div > div > div._59wYedBC31WQNSpSiAnI- > main > div > div > div._3PoaE74AE-EUlHsuPq6tuT > div > div > div:nth-child(1) > div > div.ReactVirtualized__Table__headerRow._2q1nO9q-LBoatlghUY01-N > div:nth-child(1) > div > span");
 
  
   @FindBy(css = "body > div.container > div > div > div > div.box-content.padded > form > div:nth-child(2) > input[type=\"text\"]")
   WebElement loginTextField;
   
   @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[2]/input")
   WebElement passwordTextField;
   
   @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[3]/button")
   WebElement loginButton;
   
    @FindBy(xpath = "/html/body/div[3]/ul/li[2]/a/span")
    WebElement menuProducts;
//   
//   @FindBy(css = "#user_password")
//   WebElement passwordTextfield;
   
    public MainPage(WebDriver driver){
    super(driver);
    
    }
    
    public MainPage login(User user){
        highlightElement(LOGIN_TEXTFIELD_LOCATOR);
        loginTextField.sendKeys(user.getLogin());
        passwordTextField.sendKeys(user.getPassword());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginButton);
        //loginButton.click();
        return new MainPage(getDriver());
    }
    
    public MainPage open() throws MalformedURLException, InterruptedException{
        getDriver().get("https://styleabelle.com/console/login");
        return this;
    }
    
//    public QueryPage openQuery(){
//       // collapseIcon.click();
//        queryIcon.click();
//        waitForElementPresent(QUERIES_LIST);
//        firstResultLink.click();
//        return new QueryPage(getDriver());
//    }
    public AddProductPage openProducts(){
        new Actions(driver).click(menuProducts).build().perform();
        return new AddProductPage(getDriver());
    }
  
}