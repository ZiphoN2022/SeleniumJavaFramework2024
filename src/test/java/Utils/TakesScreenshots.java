package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakesScreenshots {
    static String screenshotDir = System.getProperty("user.dir") + "/Screenshots";

    String fileNameTimeStamp = String.valueOf(new Date().getTime());

    public void takesSnapShot(WebDriver driver, String screenshotName, String folderPath) {

        String fileNameTimeStamp = String.valueOf(new Date().getTime()); // string to holder the time stamp for the image

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotDir + folderPath, screenshotName +"_"+ fileNameTimeStamp + ".png");
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
