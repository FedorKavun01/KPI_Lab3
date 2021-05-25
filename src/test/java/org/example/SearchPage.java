package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"listing-page-container\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/a")
    private WebElement product;
    @FindBy(xpath = "//*[@id=\"listing-page-container\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]")
    private WebElement addToBasket;
    @FindBy(xpath = "//*[@id=\"js-fix-header\"]/div/div/div[4]/div[4]")
    private WebElement openBasket;
    @FindBy(xpath = "//*[@id=\"cartTooltip\"]/div[1]/div/div/div/a")
    private WebElement basket;

    public String getProduct() {
        return product.getText();
    }

    public void addToBasketClick() {
        addToBasket.click();
    }

    public void openBasketClick() {
        openBasket.click();
    }

    public String getBasket() {
        return basket.getText();
    }
}
