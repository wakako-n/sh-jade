package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Prop {
    public Prop(){
        super();
    }
    
    private static final Map mp;
    private static Prop theApp = new Prop();
    private static String path = "/utils/config.properties";
    private static final Properties prop;
   /* public Map load(String path) throws IOException {
         Map map = this.loadProperties(path);
        return map;
    }*/
    static {
       InputStream in = Prop.class.getResourceAsStream(path);
        if (in == null) {
            throw new IllegalArgumentException(path + " not found.");
        }
        prop = new Properties();
        try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        mp = new HashMap(prop);
    }
    /*public static void main(String[] args){
        Prop theApp = new Prop();
        try{
            Map map = theApp.load("/utils/config.properties");
              
        }catch(Exception e){
            e.getMessage();
        }
    }*/
    public static String getProperty(final String key) {
        return (String)mp.get(key);
    }
 
}

