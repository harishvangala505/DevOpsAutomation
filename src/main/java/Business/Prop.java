package Business;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Prop {

    public static Prop prop = null;
    static Properties props = null;

    private Prop(){

    }

    private static String filePath = System.getProperty("user.dir") + File.separator + "DataProperties.properties";


    public static Prop getPropInstance(){

        if(prop == null){
            new Prop();
            try {
                File file = new File(filePath);
                InputStream inputStream = new FileInputStream(file);
                props = new java.util.Properties();
                props.load(inputStream);
                System.out.println("********* getPropInstance() called and Properties are loaded *********");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return prop;
    }



    public static String getProperty(String key){
        String propText = "";
        try {
            propText = props.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return propText;
    }

}
