package gestures;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TapAction {
    @Test
    public void tapTest() throws MalformedURLException {
        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability("deviceName","alenaBelkina");
        caps.setCapability("automationName","uiautomator2");
        caps.setCapability("app",apkFile.getAbsolutePath());
        URL serverUrl=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver(serverUrl,caps);
        WebElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction tapAction=new TouchAction(driver);
        tapAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        WebElement expandableList = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
        tapAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();

        WebElement customAdapt=driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
        tapAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapt))).perform();

        WebElement peopleNames=driver.findElement(By.xpath("//*[@text='People Names']"));
        tapAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(2))).perform();


    }

    @Test
    public void scrollTest() throws MalformedURLException {
        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"alenaBelkina");
        caps.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setPlatform(Platform.ANDROID);

        URL appiumServerUrl=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver<>(appiumServerUrl,caps);
        WebElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");
        WebElement tabsButton=driver.findElementByAccessibilityId("Tabs");
        tabsButton.click();



    }

}
