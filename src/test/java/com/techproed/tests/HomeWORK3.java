package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class HomeWORK3 extends TestBase {
    /**
     //CREATE A METHOD DROPDOWN TEST
     //GO TO https://www.amazon.com
     //find the element of dropdown element.HINT: By.id("searchDropDownBox")
     //print the first selected option and assert if it is equals "All Departments"
     //select the 4th option by index(index of 3) and assert if the name is "Amazon Devices".(after you select you
     // need to use get first selected option method
     //print all the dropdown options-get options(); method returns the List<WebElement> using loop
     //print all options
     //Print the total  number of options in the dropdown
     //Check if 'Appliances' is a dropdown option print True if "Appliances" is an option.Print false otherwise
     //BONUS:Check if the dropdown is in Alphabetical order
     */

    //CREATE A METHOD DROPDOWN TEST
    //GO TO https://www.amazon.com
    @Test
    public void dropdownTest() throws InterruptedException {
        //GO TO https://www.amazon.com
        driver.get("https://www.amazon.com");
        //find the element of dropdown element.HINT: By.id("searchDropDownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        dropdown.click();
        Thread.sleep(500);
        //print the first selected option and assert if it is equals "All Departments"
        Select select1 = new Select(dropdown);
        String firstOne = select1.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOne, "All Departments");
        //select the 4th option by index(index of 3) and assert if the name is "Amazon Devices".(after you select you
        select1.selectByIndex(3);
        Thread.sleep(500);
        String index3 = select1.getFirstSelectedOption().getText();
        Assert.assertEquals(index3, "Amazon Devices");
        System.out.println("Amazon Devices = " + index3);
        //print all the dropdown options-get options(); method returns the List<WebElement> using loop
        //print all options
        int a = 0;
        List<WebElement> allOptions = select1.getOptions();
        for (WebElement all : allOptions){
            System.out.println(all.getText());
            a++;
        }
        //Print the total  number of options in the dropdown
        System.out.println(a);
        //Check if 'Appliances' is a dropdown option print True if "Appliances" is an option.Print false otherwise
        int b = 0;
        for (WebElement all : allOptions){
            if (all.getText().equals("Appliances")){
                b++;
            }
        }
        if (b == 1){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        //BONUS:Check if the dropdown is in Alphabetical order
        List<String> originalList = new ArrayList();
        for (WebElement e : select1.getOptions()) {
            originalList.add(e.getText());
        }
        List<String> tempList= originalList;
        Collections.sort(tempList);
        Assert.assertEquals(tempList, originalList);
    }
}
