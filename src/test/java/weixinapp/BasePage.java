package weixinapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author wangqian
 * @Date 2020-11-19 15:46
 * @Version 1.0
 */
public class BasePage {
    public static AppiumDriver driver;

    WebDriverWait wait;

    public BasePage() {
    }

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    void waitDe(By by){
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    void click2(String expression){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        driver.findElementByAndroidUIAutomator(expression).click();
    }
    void sendKeys2(String expression,String content){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        driver.findElementByAndroidUIAutomator(expression).sendKeys(content);
    }
    void click1(By by){
        driver.findElement(by).click();
    }
    void sendsKeys1(By by,String content){
        driver.findElement(by).sendKeys(content);
    }
}
