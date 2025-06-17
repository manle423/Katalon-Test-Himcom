import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeePermanentEmployees'()

WebDriver driver = DriverFactory.getWebDriver()

// Lấy danh sách tất cả link “View Employee”
List<WebElement> companyLinks = driver.findElements(By.xpath("//table//tbody//tr/td[3]/a"))

for (int i = 0; i < companyLinks.size(); i++) {
	// Re-find element sau mỗi lần navigate
	companyLinks = driver.findElements(By.xpath("//table//tbody//tr/td[3]/a"))
	companyLinks[i].click()

	WebUI.delay(2)

	List<WebElement> employeeRows = driver.findElements(By.xpath("//table//tbody//tr"))

	if (employeeRows.size() == 0) {
		// Không có nhân viên → quay lại
		WebUI.click(findTestObject('Object Repository/Page_Permanent Employees - List  E STAFF/button_Back'))
		WebUI.delay(1)
		continue
	}

	// Có nhân viên → lấy tên nhân viên đầu tiên
	String firstEmployeeName = employeeRows[0].findElement(By.xpath("td[1]")).getText()

	// Nhập tên vào ô search
	WebElement searchBox = driver.findElement(By.cssSelector("input[type='search']"))
	searchBox.clear()
	searchBox.sendKeys(firstEmployeeName)

	// Click nút tìm kiếm
	WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"))
	searchBtn.click()
	WebUI.delay(1)

	// Xác minh có kết quả đúng
	List<WebElement> searchResults = driver.findElements(By.xpath("//table//tbody//tr"))
	assert searchResults.size() > 0 : "Không tìm thấy kết quả sau khi tìm nhân viên: $firstEmployeeName"

	WebUI.comment("Tìm thấy nhân viên [$firstEmployeeName] thành công.")
	break // Dừng lại sau khi test thành công một công ty có nhân viên
}