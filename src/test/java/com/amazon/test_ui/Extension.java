package com.amazon.test_ui;

import com.amazon.utilities.WriteToText;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;

public class Extension {
    String fileName = "extensionPage";


    @Test
    public void extensionInstall() {
        //Setting up ChromeDriver with WebDriver Manager.
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //Add my downloaded crx file path below.
        options.addExtensions(new File("C:/Users/alica/Downloads/extension_7_6_0_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        WebDriver driver = new ChromeDriver(options);
        driver.get("chrome-extension://fdpohaocaechififmbbbbbknoalclacl/html/popup.html");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String url = driver.getCurrentUrl().toString();
        WriteToText.write(fileName, "1. EXTENSION PAGE URL : \n" + url);
        String pageTitle = driver.getTitle().toString();
        WriteToText.write(fileName, "2. EXTENSION PAGE TITLE : \n" + pageTitle);
    }

}
