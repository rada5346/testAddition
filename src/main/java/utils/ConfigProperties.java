package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static FileInputStream fileInputStream;
    private static Properties properties;

    static{
        try {
            File file = new File("src/main/resources/config.properties");
            fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream !=null){
                try{
                    fileInputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getTestProperty(String key){
        return properties.getProperty(key);
    }

}
