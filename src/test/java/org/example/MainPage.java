package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"js-fix-header\"]/div/div/div[3]/input[1]")
    private WebElement searchLine;
    @FindBy(xpath = "//*[@id=\"js-fix-header\"]/div/div/div[3]/input[2]")
    private WebElement searchButton;

    public void inputSearch(String search) {
        searchLine.sendKeys(search);
    }

    public void clickOnSearch() {
        searchButton.click();
    }
}
