package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/TjKhan/Desktop/PIIT/SELENIUM/WebDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
    }

    public String getToURL(String url) {
        driver.get(url);
        System.out.println("\n" +url);
        return url;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("\n" +url);
        return url;
    }

    public String getCurrentPageTitle() {
        String title = driver.getTitle();
        System.out.println("\n" +title);
        return title;
    }

    public void titleValidate(String expected) {
        String title = driver.getTitle();
        Assert.assertEquals(title, expected);
        System.out.println(title);
    }

    public void searchValidate(String expected) {
        String search = driver.getTitle();
        Assert.assertEquals(search, expected);
        System.out.println("Search result match >> " +search);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void getErrorMessage(String locator) {
        System.out.println(driver.findElement(By.cssSelector(locator)).getText());

    }

    public void clickOnXPath (String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnElement(String css, String xpath, String id) {
        try {
            driver.findElement(By.cssSelector(css)).click();
        } catch (Exception ex1) {
            try {
                driver.findElement(By.xpath(xpath)).click();
            } catch (Exception ex2) {
                driver.findElement(By.id(id)).click();
            }
        }
    }

    public void typeOnInputBox(String css, String name, String id, String value) {
        try {
            driver.findElement(By.id(id)).sendKeys(value);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(name)).sendKeys(value);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(css)).sendKeys(value);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }

    public void typeOnInputBoxEnter(String css, String name, String id, String value) {
        try {
            driver.findElement(By.id(id)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(name)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(css)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }





}
