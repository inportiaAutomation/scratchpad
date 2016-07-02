package com.inportia.scratchpad.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkboxes {
    
	 static String targetUrl = "http://the-internet.herokuapp.com/checkboxes";
	 
	 public static void test(WebDriver driver)
	 {
		 /*
		  *  Since we have 2 checkboxes with no unique identifier inside a unique form
		  *  we need to get the list of checkboxes and then iterate over the checkboxes
		  * */
		 
		 driver.get(Checkboxes.targetUrl);
		 // find the list of checkboxes
		 WebElement checkbox_form = driver.findElement(By.id("checkboxes"));
		 List<WebElement> checkboxes = checkbox_form.findElements(By.tagName("input"));
		
		 // checkboxes
		 System.out.println("Found "+checkboxes.size()+" checkboxes under <form id=\"checkboxes\">");
		 Checkboxes.select_only_first_checkbox(checkboxes);
		 
	 }
	 
	 public static void select_only_first_checkbox(List<WebElement> chkboxs)
	 {
		 //first deselect all the checkboxes
		 
	 }
}
