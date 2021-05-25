package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SiteTest {
    public static MainPage mainPage;
    public static SearchPage searchPage;
    public static WebDriver driver;

    private static String driverWay = "chromedriver";
    private static String siteUrl = "https://www.foxtrot.com.ua/";
    private String searchResponse = "Smart watch";
    private String expectedResult = "Смарт-часы SAMSUNG Galaxy Watch 3 45mm Black (SM-R840NZKASEK)";

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", driverWay);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(siteUrl);

        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void searchTest() {
        mainPage.inputSearch(searchResponse);
        mainPage.clickOnSearch();
        String product = searchPage.getProduct();
        System.out.println(product);

        searchPage.addToBasketClick();
        System.out.println("--------------------------------------------------");

        Assert.assertEquals(expectedResult, product);

        String basketProductName = searchPage.getBasket();
        System.out.println(basketProductName);

        Assert.assertEquals(expectedResult, basketProductName);
    }

    @AfterClass
    public static void shutDown() {
        driver.quit();
    }
}
