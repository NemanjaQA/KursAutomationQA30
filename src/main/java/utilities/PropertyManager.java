package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {

    private static String driverPath, goodEmail, goodPassword, firstName, lastName, badPassword;
    private static String configFilePath = "src/main/resources/configuration.properties";
    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if(instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }
    private void loadData(){
        Properties properties = new Properties();
        try {
            FileInputStream fi = new FileInputStream(configFilePath);
            properties.load(fi);
        }catch (Exception e){
            e.printStackTrace();
        }
        driverPath = properties.getProperty("driverPath");
        goodEmail = properties.getProperty("goodEmail");
        goodPassword = properties.getProperty("goodPassword");
        firstName = properties.getProperty("firstName");
        lastName = properties.getProperty("lastName");
        badPassword = properties.getProperty("badPassword");
    }
    public static void changeProperty(String key, String value){
        Properties editProperties = new Properties();
        try {
            FileInputStream editFi = new FileInputStream(configFilePath);
            editProperties.load(editFi);
            editProperties.setProperty(key, value);
            editProperties.store(new FileOutputStream(configFilePath), null);
        }catch (Exception e){
            e.printStackTrace();
        }
        instance = null;
    }

    public String getDriverPath() {
        return driverPath;
    }
    public String getGoodEmail() {
        return goodEmail;
    }
    public String getGoodPassword() {
        return goodPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBadPassword() {
        return badPassword;
    }
}
