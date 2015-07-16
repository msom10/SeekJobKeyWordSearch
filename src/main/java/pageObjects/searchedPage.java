package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Mohanish on 12/07/15.
 */
public class searchedPage {

    private static WebElement element = null;

    public static WebElement btn_next(WebDriver driver){

        element = driver.findElement(By.xpath(".//*[@id='job-listing-wrapper']/div[5]/dl/dd[12]/a"));

        return element;

    }

    public static WebElement txt_totNumberOfJobs(WebDriver driver){

        element = driver.findElement(By.xpath(".//*[@id='bindingRoot']/div/div[1]/div[1]/span"));

        return element;

    }

    public static WebElement txt_position(WebDriver driver,int position){

        element = driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[1]/h2/a"));

        return element;

    }

    public static WebElement txt_advertiserName(WebDriver driver,int position){

        element = driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[1]/h2/em"));

        return element;

    }


    public static WebElement txt_jobDescription(WebDriver driver,int position){

        element = driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[1]/p"));

        return element;

    }

    public static WebElement txt_ListingDate(WebDriver driver,int position){

        element = driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[2]/span[1]"));

        return element;

    }

    public static WebElement txt_SalaryRange(WebDriver driver,int position){

        element = driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[2]/span[2]"));

        return element;

    }

    public static WebElement txt_Location(WebDriver driver,int position){

        element =  driver.findElement(By.xpath(".//*[@id='jobsListing']/div[2]/article["+position+"]/dl/dd[2]/span[3]"));

        return element;

    }

    public static WebElement link_Page(WebDriver driver,int pageNumber){

        element = driver.findElement(By.linkText(Integer.toString(pageNumber)));

        return element;

    }

    public static List<WebElement> link_Page_Exist(WebDriver driver,int pageNumber){

        List<WebElement> element = driver.findElements(By.linkText(Integer.toString(pageNumber)));

        return element;

    }


}
