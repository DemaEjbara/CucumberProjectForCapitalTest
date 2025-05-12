package HelpersUtils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class locatorUtil {
    private  static final Properties properties =new Properties();
    static {
        try{
            FileInputStream fis=new FileInputStream("src/test/resources/locators.properties");
            properties.load(fis);
        }
        catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("the properties file can not be loaded");
        }
    }
  public static By GetLocator(String key){
        String locator=properties.getProperty(key);
        if (locator==null || locator.trim().isEmpty()){
            throw new IllegalArgumentException("no locator found for th key :"+key);
        }
        return By.xpath(locator.trim());
  }
  public static String getText(String key){
        String text =properties.getProperty(key + ".text");
        if(text==null || text.trim().isEmpty()){
            throw new IllegalArgumentException("No found text for this locator ");
        }
        return text.trim();
  }
}
