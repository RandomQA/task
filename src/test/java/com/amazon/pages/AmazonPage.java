package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Hello, Sign in']")
    public WebElement signInMenu;

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement LastSingInButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[1]")
    public WebElement firstProduct;

    @FindBy(id = "productTitle")
    public WebElement productTitle;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstSearchedResult;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    public WebElement showCart;

    @FindBy(xpath = "//span[@class='a-truncate-full a-offscreen']")
    public WebElement productName;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement productValue;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    public WebElement productQuantity;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    public WebElement totalProduct;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
    public WebElement totalValueOfProduct;

    @FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@data-action='page-spinner-show']")
    public WebElement adressButton;

    @FindBy(xpath = "//*[@id='shippingOptionFormId']/div[2]/div/div[1]/div/div/ul/li/div/strong")
    public WebElement productNameCheckout;

    @FindBy(xpath = "//span[@class='a-color-price']")
    public WebElement priceCheckout;

    @FindBy(xpath = "//span[@class='a-color-secondary']")
    public WebElement totalProductonCheckout;
}
