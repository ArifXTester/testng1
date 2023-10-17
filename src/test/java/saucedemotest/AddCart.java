package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCart extends SetUp {
    @Test
    public void test1() throws InterruptedException {

        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        System.out.println("user name field found");
        WebElement passwordField = driver.findElement(By.id("password"));
        System.out.println("PW field found");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        System.out.println("login button found");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


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
     Assert.assertEquals(expectedLoginPageURL,actualLoginPageURL);
     System.out.println("Login to website successful");

     //Add item to cart & verify item was added to cart
       driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
       String expectedItem = "1";
       String actualItem = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
       Assert.assertEquals(expectedItem,actualItem);
       System.out.println("Item added to cart successfully");

//       //Click on shopping Cart
     driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
//    //Check if shopping cart page is displayed
//        String expectedCartPageURL = "Your Cart";
//        String actualCartPage = driver.findElement(By.linkText("Your Cart")).getText();
//        Assert.assertEquals(expectedCartPage,actualCartPage);
//        System.out.println("Shopping Cart page successful");

        //Another way to check if shopping cart page is displayed
        String expectedURL = "https://www.saucedemo.com/cart.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);
        System.out.println("Shopping Cart page successful");

        //Verify checkout page is displayed
        driver.findElement(By.id("checkout")).click();
        String expectedCheckoutURL = "https://www.saucedemo.com/checkout-step-one.html";
        String actualCheckoutURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCheckoutURL,actualCheckoutURL);
        System.out.println("Checkout page displayed successfully");

        WebElement FirstName = driver.findElement(By.id("first-name"));
        System.out.println("first name field found");
        WebElement LastName = driver.findElement(By.id("last-name"));
        System.out.println("last name field found");
        WebElement ZipCode = driver.findElement(By.id("postal-code"));
        System.out.println("zip code field found");

        //Enter First Name
        FirstName.sendKeys("John");
        System.out.println("First Name entered successfully");
        //Enter Last Name
        LastName.sendKeys("Kimbel");
        System.out.println("Last Name entered successfully");
        //Enter Zip Code
        ZipCode.sendKeys("90210");
        System.out.println("Valid zip code entered successfully");

        //Verify Checkout Overview Page
        driver.findElement(By.id("continue")).click();
        String expectedChkOverview = "https://www.saucedemo.com/checkout-step-two.html";
        String actualChkOverview = driver.getCurrentUrl();
        Assert.assertEquals(expectedChkOverview, actualChkOverview);
        System.out.println("Checkout Overview Page Displayed successfully");

        //Verify Payment Information is Correct
        String expectedPaymentInfo = "SauceCard #31337";
        String actualPaymentInfo = driver.findElement(By.xpath("//div[@class='summary_value_label']")).getText();
        Assert.assertEquals(expectedPaymentInfo, actualPaymentInfo);
        System.out.println("Payment Info Verified Successfully");

        //Click on Finish Checkout
        driver.findElement(By.id("finish")).click();

        //Confirm Checkout Complete
        String expectedCheckoutPage = "https://www.saucedemo.com/checkout-complete.html";
        String actualCheckoutPage = driver.getCurrentUrl();
        Assert.assertEquals(expectedCheckoutPage, actualCheckoutPage);
        System.out.println("Checkout Page Message displayed successfully");
    }
}
