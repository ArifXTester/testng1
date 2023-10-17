package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class dropDown extends SetUp {
    @Test
    public void test1() throws InterruptedException {
        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        System.out.println("user name field found");
        WebElement passwordField = driver.findElement(By.id("password"));
        System.out.println("PW field found");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        System.out.println("login button found");

        // Enter an incorrect username and a valid password
        usernameField.sendKeys("standard_user");
        System.out.println("valid username entered");
        passwordField.sendKeys("secret_sauce");
        System.out.println("valid password entered");

        // Click the login button
        loginButton.click();
        System.out.println("login button clicked");

        // Check if the login is successful (verify that we are on the inventory page)
        //  System.out.println(driver.getCurrentUrl());
        String expectedLoginPageURL = "https://www.saucedemo.com/inventory.html";
        String actualLoginPageURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedLoginPageURL, actualLoginPageURL);
        System.out.println("Login to website successful");

        //Select item from dropdown menu
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (Z to A)");

        //Verify items are sorted from Z to A
        String expectedText = "Test.allTheThings() T-Shirt (Red)";
        String actualText = driver.findElement(By.partialLinkText("T-Shirt (Red")).getText();
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Sort by descending selected successfully");
    }
}



