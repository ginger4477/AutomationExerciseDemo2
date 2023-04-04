package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage extends  Pages{

    private final String url = "https://automationexercise.com/products";
    private final By SEARCH_INPUT = By.id("search_product");
    private final By BUTTON_SEARCH = By.id("submit_search");
    private final By ITEM = By.xpath("//*[@class='features_items']/div[@class='col-sm-4']/div/div/div/p");

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    @Step("first method")
    public void searchItem(String itemName) {
        driver.findElement(SEARCH_INPUT).sendKeys(itemName);
    }


    @Step("second method")
    public void clickOnSearchButton() {
        driver.findElement(BUTTON_SEARCH).click();
    }


    @Step("return elements")
    public String[] listItems() {
        List<WebElement> items = driver.findElements(ITEM);
        String[] resultArray = new String[items.size()];
        int count = 0;
        for(WebElement item : items) {
            resultArray[count++] = item.getText();
        }
        return resultArray;
    }




}
