package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

    @Test
    public void searchProductTest() {
        driver.get("https://www.amazon.com/");
        
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        Assert.assertTrue(result.isDisplayed(), "Search results are not displayed!");
    }
}
