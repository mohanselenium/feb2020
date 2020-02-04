package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the driver 
	 * 
	 * @param browsername
	 * @return
	 */

	public WebDriver init_driver(String browsername) {

		if (browsername.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browsername.equals("ff")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		else if (browsername.equals("safari")) {
			// later

		}

		else {

			System.out.println(browsername + " browser value is worng ,please pass the correct browsername");
		}

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com");

		return driver;

	}
	
	/**
	 * 
	 * This method is used to read the properties from config prpoerites file
	 * @return
	 */

	public Properties init_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\MohanaKrishnanRajara\\eclipse-workspace\\Project1\\Jan2020\\src\\main\\java\\com\\qa\\hubspot\\config\\Config properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("config file is missing please check it ");

		} catch (IOException e) {
			
			System.out.println("properties could not be loaded ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}   
	
}
