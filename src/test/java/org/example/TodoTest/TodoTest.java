package org.example.TodoTest;

import org.example.MainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TodoTest {
    public static TodoMainPage todoMainPage;
    public static WebDriver driver;

    private static String driverWay = "chromedriver";
    private static String siteUrl = "https://todomvc.com/examples/angularjs/#/";
    private String searchResponse = "Smart watch";
    private String expectedResult = "Смарт-часы SAMSUNG Galaxy Watch 3 45mm Black (SM-R840NZKASEK)";

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", driverWay);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(siteUrl);

        todoMainPage = new TodoMainPage(driver);
    }

    @Test
    public void main() {
//        mainPage.inputSearch(searchResponse);
//        mainPage.clickOnSearch();
//        String product = searchPage.getProduct();
//        System.out.println(product);
//
//        searchPage.addToBasketClick();
//        System.out.println("--------------------------------------------------");
//
//        Assert.assertEquals(expectedResult, product);
//
//        String basketProductName = searchPage.getBasket();
//        System.out.println(basketProductName);
//
//        Assert.assertEquals(expectedResult, basketProductName);

        addSomethingTest();
        checkSomethingTest();
        activeTest();
        completeTest();
    }

    @Test
    public void addSomethingTest() {
        todoMainPage.addSomething("Add");
        todoMainPage.addSomething("Check");
        todoMainPage.addSomething("Active");
        todoMainPage.addSomething("Completed");

        String expectedResult = "Add\nCheck\nActive\nCompleted";

        Assert.assertEquals(expectedResult, todoMainPage.getAllTasks());
    }

    @Test
    public void checkSomethingTest() {
        todoMainPage.clickOnCheck();

        String expectedResult = "Add\nCheck\nActive\nCompleted";

        Assert.assertEquals(expectedResult, todoMainPage.getAllTasks());
    }

    @Test
    public void activeTest() {
        todoMainPage.clickOnActive();

        String expectedResult = "Check\nActive\nCompleted";

        Assert.assertEquals(expectedResult, todoMainPage.getAllTasks());
    }

    @Test
    public void completeTest() {
        todoMainPage.clickOnCompleted();

        String expectedResult = "Add";

        Assert.assertEquals(expectedResult, todoMainPage.getAllTasks());
    }

    @AfterClass
    public static void shutDown() {
        driver.quit();
    }
}
