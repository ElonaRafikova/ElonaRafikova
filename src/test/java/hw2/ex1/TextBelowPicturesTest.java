package hw2.ex1;

import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

public class TextBelowPicturesTest extends TestBase {
    @Test(dataProvider = "simpleDataProvider", dataProviderClass =DataProviders.class)
    public void simpleTest (String text, int number){

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are text on the Index Page under icon and they have proper text
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.size(), 4);
        assertEquals(textsUnderIcons.get(number).getText(),text);

        //4 Close BR
        driver.close();
        System.out.println(text);



    }
}
