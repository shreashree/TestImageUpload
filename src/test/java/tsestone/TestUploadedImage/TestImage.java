package tsestone.TestUploadedImage;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestImage {
	public static void main(String[] args) throws InterruptedException {
		Playwright pw = Playwright.create();
		Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = br.newPage();
		
		page.navigate("http://localhost:8080/");

		String imgPath = "C:\\Users\\shreya shree\\Downloads\\img1.jpeg";
		 
		ElementHandle fileInput =page.querySelector("input[type='file']");
		Thread.sleep(200);
		fileInput.setInputFiles(Paths.get(imgPath));
	 
		Thread.sleep(200);
		page.locator("#app > div > button").click();
		
		page.close();
		br.close();
		pw.close();
		
	}

}
