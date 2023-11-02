package tsestone.TestUploadedImage;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestImage {
//	public static void main(String[] args) throws InterruptedException {
	
	@Test
	public static void checkWEbElemet() throws InterruptedException {
		
	
		Playwright pw = Playwright.create();
		Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = br.newPage();
		
//		navigating the required page by url 
		page.navigate("http://localhost:8080/");

//		path of image
		String imgPath = "C:\\Users\\shreya shree\\Downloads\\img1.jpeg";
		 
//		finding "choose button" element 
		ElementHandle fileInput =page.querySelector("input[type='file']");
		Thread.sleep(2000);

		
//		uploading image through imgPath variable
		fileInput.setInputFiles(Paths.get(imgPath));
		
		
//		find element "show extracted text" button and click
		page.locator("#app > div > button").click();
		Thread.sleep(100);
		
//		testing textarea visibility
		ElementHandle element = page.waitForSelector("//*[@id=\"app\"]/div/div[2]/textarea");
		
		boolean elementIsVisible = element.isVisible();
		Thread.sleep(200);
		Assert.assertTrue(elementIsVisible, "true");
		System.out.println("is visible " + elementIsVisible);
		Thread.sleep(1000);
		
		page.close();
		br.close();
		pw.close();
		
	}

}
