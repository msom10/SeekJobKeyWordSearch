package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.home_page;
import pageObjects.searchedPage;
import pojo.job;
import utility.constants;
import utility.excelUtilty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mohanish on 11/07/15.
 */
public class searchByKeyword {

    private static WebDriver driver = null;

    public static void main(String[] args) throws Exception {

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(constants.url);

        home_page.txtBox_KeyWords(driver).sendKeys(constants.keyWord);

        Select select = new Select(home_page.dropDown_Location(driver));
        select.selectByVisibleText(constants.location);

       // Thread.sleep(20000);

        home_page.btn_Seek(driver).click();

      //get number of jobs
      //System.out.println("^%&^%&^%*"+searchedPage.txt_totNumberOfJobs(driver).getText());
        List<job> allJobs = new ArrayList<job>();
        String tempNumberOfJobs = searchedPage.txt_totNumberOfJobs(driver).getText();
        tempNumberOfJobs = tempNumberOfJobs.replaceAll("\\D+","");
        double numberOfiteration =  (Integer.parseInt(tempNumberOfJobs)/20.0);
        int iterate = (int) Math.ceil(numberOfiteration);


        for(int i =1;i<=iterate;i++){
            //get the total number of jobs listed in page
            List<WebElement> article = driver.findElements(By.tagName("article"));
            int count = article.size();
            //System.out.println("Number of jobs "+count);

            for(int j=1;j<=count;j++) {

                //attributes to be retrieved from each job
                String position = searchedPage.txt_position(driver, j).getText();
                String jobLink = searchedPage.txt_position(driver, j).getAttribute("href");
                String jobId = (String) jobLink.subSequence(27,35);//extracting job id from the link
                String advertiser = searchedPage.txt_advertiserName(driver, j).getText();
                String jobDescription = searchedPage.txt_jobDescription(driver, j).getText();
                String listingDate = searchedPage.txt_ListingDate(driver, j).getText();
                String SalaryRange = searchedPage.txt_SalaryRange(driver, j).getText();
                String location = searchedPage.txt_Location(driver, j).getText();

                job tempJob = new job();
                tempJob.setPosition(position);
                tempJob.setAdvertiser(advertiser);
                tempJob.setJobDescription(jobDescription);
                tempJob.setListingDate(listingDate);
                tempJob.setSalaryRange(SalaryRange);
                tempJob.setLocation(location);
                tempJob.setJobLink(jobLink);
                tempJob.setJobId(jobId);

                allJobs.add(tempJob);

               // System.out.println("*&^*(&" + jobLink+position );
               // System.out.println("****"+jobId);
            }

            //go to next page
            //searchedPage.btn_next(driver).click();
            if(searchedPage.link_Page_Exist(driver,i+1).size()>0) {
                searchedPage.link_Page(driver, i + 1).click();
                System.out.println("^^^ Clicking "+i);
            }
        }

        //System.out.println("Total Jobs: "+allJobs.size());

        System.out.println("Writing to excel started!");

        //save all jobs to excel
        //intialize the excel
        excelUtilty.setExcelFile(constants.result_location+constants.result_file,"Sheet1");
        for(int k = 1;k<allJobs.size();k++){
            excelUtilty.setCellData(allJobs.get(k).getPosition(),k,1);//postion
            excelUtilty.setCellData(allJobs.get(k).getAdvertiser(),k,2);//advertiser
            excelUtilty.setCellData(allJobs.get(k).getJobDescription(),k,3);//job description
            excelUtilty.setCellData(allJobs.get(k).getListingDate(),k,4);//listing date
            excelUtilty.setCellData(allJobs.get(k).getSalaryRange(),k,5);//salary range
            excelUtilty.setCellData(allJobs.get(k).getLocation(),k,6);//Location
            excelUtilty.setCellData(allJobs.get(k).getJobId(),k,7);//jobID
            excelUtilty.setCellData(allJobs.get(k).getJobLink(),k,8);//link
            System.out.println("**** written Row "+k);
        }

        System.out.println("writing to excel completed!");


    }

}
