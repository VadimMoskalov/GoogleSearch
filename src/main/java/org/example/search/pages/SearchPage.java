package org.example.search.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy(name = "q")
    private WebElement searchLine;

    @FindBy(css = "[name=btnK]")
    private WebElement searchButton;


    public String Search(String text){
        searchLine.clear();
        searchLine.sendKeys(text);
        searchLine.sendKeys(Keys.ENTER);
//        while (!searchButton.isEnabled()){
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        searchButton.click();

        return searchLine.getAttribute("value");
    }
}
