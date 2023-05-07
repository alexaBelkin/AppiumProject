package utilsMobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    public static AndroidDriver getAndroidDriver(String apkFilename){
        File apkFile=new File("src/test/resources/"+apkFilename+".apk");
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"alenaBelkina");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());


        try{
            URL serverUrl=new URL("http://0.0.0.0:4723/wd/hub");
            AndroidDriver driver=new AndroidDriver(serverUrl,caps);
            return driver;
        }catch (MalformedURLException exep){
            throw new RuntimeException();
        }

    }
}
