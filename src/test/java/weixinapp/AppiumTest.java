package weixinapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author wangqian
 * @Date 2020-11-19 15:44
 * @Version 1.0
 */
public class AppiumTest extends BasePage{

   @BeforeAll
    public static void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        try {
            caps.setCapability("platformName","android");
            caps.setCapability("udid","127.0.0.1:7555");
            caps.setCapability("deviceName","aaa");
            caps.setCapability("appPackage","com.tencent.wework");
            caps.setCapability("noReset","true");
            caps.setCapability("appActivity",".launch.WwMainActivity");
            driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
   /* public MemberTest conack(){
       return new MemberTest();
    }*/

    @Test
    public void connectMember() throws InterruptedException {

        driver.findElement(MobileBy.id("i6n")).click();
        driver.findElement(MobileBy.id("gpg")).sendKeys("005");
        Thread.sleep(3000);
        String i1e = driver.findElement(MobileBy.id("i1e")).getText();
        System.out.println(i1e);
    }

    @Test
    public void addMember(){
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/egd\").text(\"通讯录\")");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"添加成员\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/cox\")");
        sendKeys2("new UiSelector().resourceId(\"com.tencent.wework:id/b4t\").text(\"必填\")","王五");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"设置部门\")");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"222\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/gsh\")");
        sendKeys2("new UiSelector().resourceId(\"com.tencent.wework:id/fow\")","18789098762");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/i6k\")");
    }
    @Test
    public void deleteMember(){
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/egd\").text(\"通讯录\")");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"0\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/i6d\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/b_x\")");
        click2("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().resourceId(\"com.tencent.wework:id/elh\").instance(0));");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/blx\")");
        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.tencent.wework:id/elh\")").click();
    }
    @Test
    public void editMember(){

        click2("new UiSelector().resourceId(\"com.tencent.wework:id/egd\").text(\"通讯录\")");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"005\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/i6d\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/b_x\")");
        //sendKeys2("new UiSelector().className(\"android.widget.EditText\").text(\"手机号\")","13452678965");
        //sendKeys2("new UiSelector().resourceId(\"com.tencent.wework:id/ema\")","测试");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"设置部门\")");
        click2("new UiSelector().className(\"android.widget.TextView\").text(\"222\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/gsh\")");
        click2("new UiSelector().resourceId(\"com.tencent.wework:id/i6k\")");
    }
}
