package com.amazon.test_ui;

import com.amazon.pages.AmazonPage;
import com.amazon.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import static javax.swing.text.html.CSS.getAttribute;

public class AmazonUiTest {
    AmazonPage amazonPage;

    String url = ConfigReader.getProperty("amazonUrl");
    String searchItem = ConfigReader.getProperty("searchItem");
    String email = ConfigReader.getProperty("email");
    String password = ConfigReader.getProperty("password");
    String fileName = "productDetails";

    @Before
    public void setUp() throws Exception {
        Log4j.startLog("Test  is Starting");
        Driver.getDriver().get(url);
        Log4j.info("Opening Page : " + url);
    }

    @Test
    public void amazonTestPage() {
        amazonPage = new AmazonPage();
        ReusableMethods.hover(amazonPage.signInMenu);
        Log4j.info("Hower over to the Sign In Menu");
        ReusableMethods.waitFor(2);
        amazonPage.signInButton.click();
        Log4j.info("Sign In button is Clicked");
        amazonPage.emailTextBox.sendKeys(email);
        Log4j.info("Email Entered.");
        amazonPage.continueButton.click();
        Log4j.info("Continue button Clicked");
        amazonPage.passwordTextBox.clear();
        Log4j.info("Password TextBox cleared.");
        amazonPage.passwordTextBox.sendKeys(password);
        Log4j.info("Password Entered.");
        amazonPage.LastSingInButton.click();
        Log4j.info("Sign In button is Clicked");
        amazonPage.searchTextBox.sendKeys(searchItem);
        Log4j.info("Search term typed to the textbox");
        String termOfSearch = Driver.getDriver().findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        Log4j.info("Search term taken from searchtextbox.");
        WriteToText.write(fileName, "2b. SEARCH TERM : \n" + termOfSearch);
        Log4j.info("Product details taken from Website to productsDetails txt file.");
        ReusableMethods.waitForPageToLoad(3);
        amazonPage.searchButton.click();
        Log4j.info("Clicked the search button");
        ReusableMethods.waitFor(2);
        amazonPage.firstProduct.click();
        Log4j.info("Clicked the first product");
        WriteToText.write(fileName, "======================\n======================\n2c. ITEM NAME : \n" + amazonPage.productTitle.getText());
        amazonPage.addToCart.click();
        Log4j.info("Product added to cart.");
        amazonPage.showCart.click();
        ReusableMethods.waitFor(2);
        WriteToText.write(fileName, "======================\n======================\n2e. PRODUCT NAME ON BASKET : \n" + amazonPage.productName.getText());
        WriteToText.write(fileName, "\nPRODUCT VALUE ON BASKET: \n" + amazonPage.productValue.getText());
        WriteToText.write(fileName, "\nPRODUCT QUANTITY ON BASKET: \n" + amazonPage.productQuantity.getText());
        WriteToText.write(fileName, "\nTOTAL VALUE OF PRODUCT ON BASKET : \n" + amazonPage.totalValueOfProduct.getText());
        WriteToText.write(fileName, "\nTOTAL NUMBER OF PRODUCT ON BASKET : \n" + amazonPage.totalProduct.getText());
        Log4j.info("Products on Cart is checked and added to the productsDetails txt file..");
        Driver.getDriver().navigate().back();
        Log4j.info("Navigate back to the homePage ");
        amazonPage.proceedToCheckout.click();
        Log4j.info("Proceed to the checkout page");
        amazonPage.adressButton.click();
        Log4j.info("Adress entered to the system.");
        WriteToText.write(fileName, "======================\n======================\n2f. PRODUCT NAME ON CHECKOUT: \n" + amazonPage.productNameCheckout.getText());
        WriteToText.write(fileName, "\nPRODUCT VALUE ON CHECKOUT : \n" + amazonPage.priceCheckout.getText());
        WriteToText.write(fileName, "\nPRODUCT QUANTITY ON CHECKOUT: \n" + amazonPage.totalProductonCheckout.getText());
        WriteToText.write(fileName, "\nTOTAL VALUE ON CHECKOUT : \n" + amazonPage.priceCheckout.getText());
        Log4j.info("Products on Checkout is checked and added to the productsDetails txt file.");
    }

    @After
    public void tearDown() throws Exception {
        Log4j.endLog("Test is Ending");
        Driver.closeDriver();
    }
}
