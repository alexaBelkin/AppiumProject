package error_msg;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilsMobile.GestureUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ToastMessage {

    @Test
    public void errorMessagePassed() throws MalformedURLException {
        File ecommerce=new File("src/test/resources/Codefish-Store.apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"alenaBelkina");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,ecommerce.getAbsolutePath());

        URL serverUrl=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver=new AndroidDriver<>(serverUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement letsShopButton =driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        GestureUtils.elementTap(driver,letsShopButton);
        WebElement errorMsg=driver.findElement(By.xpath("//android.widget.Toast[1]"));
        String toastText=errorMsg.getAttribute("name");
        String exoectedToastMessage="Please enter your name";
        Assert.assertEquals(exoectedToastMessage,toastText);


    }
}
