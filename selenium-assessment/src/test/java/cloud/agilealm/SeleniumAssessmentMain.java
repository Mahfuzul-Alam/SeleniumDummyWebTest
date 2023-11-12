package cloud.agilealm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class SeleniumAssessmentMain {
	static WebElement element_main = null;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// max window
		driver.manage().window().maximize();

		//baseUrl
		String BaseUrl = "https://agilealm.cloud";
		driver.get(BaseUrl);

		// get the title
		System.out.println(driver.getTitle());

		driver.findElement(By.className("signin")).click();
		sleep(2000);
		// SeleniumAssessmentPom.loginButton(driver).click();
		// email
		SeleniumAssessmentPom.email(driver).sendKeys("sejefir402@carpetra.com");
		// password
		SeleniumAssessmentPom.password(driver).sendKeys("Assessment12345$");

		// login button click
		SeleniumAssessmentPom.loginButton1(driver).click();
		sleep(5000);
		SeleniumAssessmentPom.sqaAssessmentButton(driver).click();
		sleep(3000);
		SeleniumAssessmentPom.workItemsButton(driver).click();
		sleep(3000);
		SeleniumAssessmentPom.newWorkItemsButton(driver).click();
		sleep(3000);
		SeleniumAssessmentPom.epicButton(driver).click();
		SeleniumAssessmentPom.titleEpicButton(driver).sendKeys("Selenium Assessment");

		sleep(3000);
		
		SeleniumAssessmentPom.descriptionEpicButton(driver).sendKeys("This assessment is done in Selenium.");
		SeleniumAssessmentPom.epicSaveButton(driver).click();
		sleep(3000);

		driver.quit();
	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
