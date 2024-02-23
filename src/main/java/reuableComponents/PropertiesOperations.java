package reuableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import io.opentelemetry.api.internal.StringUtils;

public class PropertiesOperations {
	static Properties properties = new Properties();
	
	public static String getPropertyValueByKey(String key) throws Exception {
		//load data from properties file
		String filePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis = new FileInputStream(filePath);
		properties.load(fis);
		
		//read data 
		
		String val = properties.get(key).toString();
		
		if(StringUtils.isNullOrEmpty(val)) {
			throw new Exception("Value is not specfied for "+key+"in properties file..");
		}
		return val;
	}
}
