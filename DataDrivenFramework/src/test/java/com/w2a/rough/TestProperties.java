package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		Properties Config= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.Properties");
		Config.load(fis);
		System.out.println(Config.getProperty("browser"));
		
		
		Properties OR = new Properties();
		
		
	}

}
