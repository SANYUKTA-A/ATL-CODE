package ATL.Brandintelle.maven.ATL.Brandintelle.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ATL_MainCode extends ATL_Basecode {
	private static final String FileUpload_ATLEST = null;
	@Test (priority = 2)	
	public void clickATL () throws Exception {
		logger = extent.createTest("ATL App Launching");
		WebElement search = driver.findElement(By.xpath("//*[@id=\"m_quicksearch_input\"]"));
		search.sendKeys("Estimate");
		Thread.sleep(5000);
		WebElement SelATL = driver.findElement(By.xpath("//*[@id=\"m_quicksearch\"]/m-portlet/div/div[3]/perfect-scrollbar/div/div[1]/div/div/div/div[1]/div[2]/span[1]"));
		SelATL.click();

	}
	@Test (priority = 3)
	public void createest () throws Exception {
		logger = extent.createTest("ATL CreateTest");
		Thread.sleep(8000);
		driver.switchTo().frame(0);

		Actions action = new Actions(driver);
		WebElement ClickHam= driver.findElement(By.xpath("//*[@id=\"m_header\"]/div/div/div[1]/div"));
		action.moveToElement(ClickHam).click().build().perform();

		WebElement clksidebar = driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul[3]/li/a/i[1]"));
		action.moveToElement(clksidebar).click().build().perform();
		Thread.sleep(3000);

		WebElement selest = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/ul[3]/li[1]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
		action.moveToElement(selest).click().build().perform();
		Thread.sleep(3000);
		
	}
	@Test(priority = 4)
	public void documentinfor () throws Exception {
		logger = extent.createTest("Document Information");
		WebElement selmedium = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[2]/div/ng-multiselect-dropdown/div/div[1]/span"));
		selmedium.click();
		WebElement TVmedium = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[2]/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"));
		TVmedium.click();
		WebElement selbrand = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[3]/div[1]/div[1]/div/button/span/span/i"));
		selbrand.click();
		Thread.sleep(5000);

		ActionClick(Search1, Data);

		WebElement brand = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-brandmaster/div/mat-dialog-content/table/tbody/tr[1]"));
		brand.click();

		WebElement clkagency = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[4]/div[1]/div/div/button/span/span/i"));
		clkagency.click();
		Thread.sleep(3000);
        Actions action1 = new Actions(driver);
		WebElement seragency = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
		action1.moveToElement(seragency).sendKeys("AARTI ADVERTISING");
		Thread.sleep(2000);
		WebElement selagency = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-vendormaster/div/mat-dialog-content/table/tbody/tr[1]/td[1]"));
		selagency.click();
		
		WebElement selcamp = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[4]/div[2]/div/div/button"));
		selcamp.click();
		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		WebElement sercamp = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-campaignmaster/div/div/mat-form-field/div/div[1]/div/input"));
		action2.moveToElement(sercamp).sendKeys("First Campaign");
		Thread.sleep(2000);
		WebElement firstcamp = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-campaignmaster/div/mat-dialog-content/table/tbody/tr[1]/td[1]"));
		firstcamp.click();
		
		WebElement savencon = driver.findElement(By.xpath("//*[@id=\"m_wizard\"]/div[2]/div[2]/div/div/div[1]/form/div[2]/div/div/div[3]/button"));
		savencon.click();
		
		WebElement impest = driver.findElement(By.xpath("//*[@id=\"m-dropzone-two\"]"));
		impest.click();
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Automation testing\\AutoITWorkspace\\FileUpload_ATLEST.exe");
		Thread.sleep(3000);
		
		WebElement apply = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/form/div[1]/div[2]/button"));
		apply.click();
		
		WebElement savecont = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div[3]/button"));
		savecont.click();
		
		WebElement correlation = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[3]/form/div[2]/div/div/div[3]/button"));
		correlation.click();
		
		WebElement clkattachment = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[4]/form/div[1]/div[2]/div"));
		clkattachment.click();
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Automation testing\\AutoITWorkspace\\FileUpload_ATLAttach.exe");
		Thread.sleep(3000);
		
		WebElement saveconattach = driver.findElement(By.xpath("//*[@id=\"m_wizard\"]/div[2]/div[2]/div/div/div[4]/form/div[2]/div/div/div[3]/button"));
		saveconattach.click();
		
		WebElement save = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[5]/form/div/div[2]/div/div/div[3]/button"));
		save.click();
		
		Thread.sleep(3000);
		
		WebElement saveest = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/button[1]"));
		saveest.click();
		Thread.sleep(3000);
		
	
	}
}


