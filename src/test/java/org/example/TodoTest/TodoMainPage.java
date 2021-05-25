package org.example.TodoTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodoMainPage {
    public WebDriver driver;

    public TodoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/ng-view/section/header/form/input")
    private WebElement addLine;
    @FindBy(xpath = "/html/body/ng-view/section/footer/ul/li[2]/a")
    private WebElement activeButton;
    @FindBy(xpath = "/html/body/ng-view/section/footer/ul/li[3]/a")
    private WebElement completeButton;
    @FindBy(xpath = "/html/body/ng-view/section/section/ul/li[1]/div/input")
    private WebElement checkButton;
    @FindBy(xpath = "/html/body/ng-view/section/section/ul")
    private WebElement tasks;

    public void addSomething(String search) {
        addLine.sendKeys(search, Keys.ENTER);
    }

    public void clickOnCheck() {
        checkButton.click();
    }

    public void clickOnActive() {
        activeButton.click();
    }

    public void clickOnCompleted() {
        completeButton.click();
    }

    public String getAllTasks() {
        return tasks.getText();
    }
}
