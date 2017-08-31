package TestSteps;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BusinessObject.User;
import PageObject.MainPage;
import PageObject.AddProductPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author marj
 */
public class Products_Test {
    
    private WebDriver driver;
    
    @BeforeClass(description = "Start browser")
    private void initBrowser() throws MalformedURLException{
    System.setProperty("webdriver.chrome.driver", "/Users/marj/Desktop/TOOLS/chromedriver");
  //  driver = new RemoteWebDriver(new URL("http://10.37.129.2:4444/wd/hub"), DesiredCapabilities.chrome());
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    driver = new ChromeDriver(capabilities);   
    driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.manage().window().maximize();
    }
    
    @Test(description = "Query search test")
    public void addProductTest() throws MalformedURLException, InterruptedException{
      //  new MainPage(driver).open().fillSearchInput("test query title").startSearch();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        new MainPage(driver).login(new User());
        
        //mainPage.fillSearchInput("test query title");
        //MainPage mainPage  = new MainPage(driver).open().fillSearchInput("test query title");
       // SearchResultsPage searchResultsPage = mainPage.startSearch();
//        //searchResultsPage.openFirstResult();
     //   QueryPage queryPage = mainPage.openQuery();//searchResultsPage.openQuery();
       //  QueryPage queryPage = mainPage.openQuery();
        AddProductPage addProductPage = mainPage.openProducts();
//        //QueryPage checkQuery = 
        addProductPage.addProduct();
//        queryPage.runQuery();
//        queryPage.readQuery();
                //Assert.assertTrue(actualPrice < 300, "incorrect query");

    }
    
//    @Test(description = "File upload")
//    public void FileUploadTest(){
//        MainPage mainPage = new MainPage(driver);
//        mainPage.open();
//        new MainPage(driver).login();
//        FileUploadPage uploadFile = mainPage.uploadFile();
//            }    
   @AfterClass(description = "Close browser")
    public void kill(){
        driver.close();
    }
}

