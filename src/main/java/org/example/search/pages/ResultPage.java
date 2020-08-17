package org.example.search.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {
    @FindBy(css = "[class=g]")
    List<WebElement> results;



    public int getResults(String text){
        int count = 0;
        for (WebElement element: results) {
            String result = element.findElement(By.xpath("//h3")).getText();
            if (result.toLowerCase().contains(text)){
                count++;
            }
        }
        return count;
    }

}
