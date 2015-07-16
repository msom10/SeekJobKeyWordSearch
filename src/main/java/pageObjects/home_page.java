package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Mohanish on 11/07/15.
 */
public class home_page {
    private static WebElement element = null;

    public static WebElement txtBox_KeyWords(WebDriver driver){

        element = driver.findElement(By.id("Keywords"));

        return element;

    }

    public static WebElement dropDown_Location(WebDriver driver){

        element = driver.findElement(By.id("catparentlocation"));

        return element;

    }

    public static WebElement btn_Seek(WebDriver driver){

        element = driver.findElement(By.id("DoSearch"));

        return element;

    }


}
