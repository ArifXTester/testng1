package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidLoginExampleTest extends SetUp {
    @Test
    public void test1() {

        // Find the username and password
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter a valid username and password
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Check if the login is successful (verify that we are on the inventory page)
        //     System.out.println(driver.getCurrentUrl());
        String expectedHeader = "Products";
        String actualHeader = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(expectedHeader,actualHeader);
        System.out.println("Login to website successful");



    }
}