package org.example.search;

import org.example.search.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest {

    private WebDriver driver;
    private SearchPage searchPage;


    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver2.exe");

        driver = new ChromeDriver();

        searchPage = PageFactory.initElements(driver, SearchPage.class);

    }

    @AfterMethod
    public void afterTest() {

        driver.quit();
    }

    @Test
    public void TestSearch(){
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        String text = searchPage.Search("java");

        boolean result = driver.getCurrentUrl().contains("https://www.google.com/search?");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(result);
        softAssert.assertEquals(text,"java");
        softAssert.assertAll();
    }

}
