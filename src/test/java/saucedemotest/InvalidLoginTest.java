package saucedemotest;
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends SetUp {
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
        passwordField.sendKeys("");
        System.out.println("blank PW entered");

        // Click the login button
        loginButton.click();
        System.out.println("login button clicked");

        // Check if there is an error message indicating invalid login
        String expectedError = "Epic sadface: Password is required";
        String actualError = driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("PW required error displayed successfully");
        Thread.sleep(2000);

    }
    @Test
    public void test2() throws InterruptedException {
        // Find the username and password input fields and the login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter an incorrect username and a valid password
        usernameField.sendKeys("");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Check if there is an error message indicating invalid login
        String expectedUserNameError = "Epic sadface: Username is required";
        String actualUserNameError = driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedUserNameError, actualUserNameError);
        Thread.sleep(2000);
    }
}