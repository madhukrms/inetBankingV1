package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Exception is : " + e.getMessage());

		}

	}

	public String getApplicationURL() {

		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {

		String userName = pro.getProperty("userName");
		return userName;
	}

	public String getPasswaord() {

		String password = pro.getProperty("password");
		return password;
	}

	public String getChromrPath() {

		String getChromrPath = pro.getProperty("chromepath");
		return getChromrPath;
	}

	public String getFirepath() {

		String firepath = pro.getProperty("firepath");
		return firepath;
	}

}
