package com.velproj.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){
		File fil = new File("./configuration/config.properties");
		try{
			FileInputStream fis = new FileInputStream(fil);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getBaseURL(){
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName(){
		String uname=pro.getProperty("userName");
		return uname;
	}
	public String getPassword(){
		String psw=pro.getProperty("password");
		return psw;
	}
}
