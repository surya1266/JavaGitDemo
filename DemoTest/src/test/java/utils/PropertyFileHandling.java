package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileHandling {
	
	
	public static String getPropertyValue(String param,String path)
	{
		String value=null;
		
		try {   
			Properties prop=new Properties();
			InputStream inputstream=new FileInputStream(path);
			prop.load(inputstream);
			value=prop.getProperty(param).toString().trim();
		   } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
		
	}

}
