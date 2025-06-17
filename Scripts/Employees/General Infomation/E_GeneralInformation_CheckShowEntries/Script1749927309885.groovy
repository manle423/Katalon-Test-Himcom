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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.By
import java.util.Random

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeesGeneralInformation'()

// Lấy dropdown element
TestObject dropdown = findTestObject('Page_Employees - List  E STAFF/select_numberOfEntries')
WebElement dropdownElement = WebUiCommonHelper.findWebElement(dropdown, 10)
Select select = new Select(dropdownElement)

List<WebElement> options = select.getOptions()

// Chọn ngẫu nhiên một option
Random rand = new Random()
int randomIndex = rand.nextInt(options.size())
WebElement selectedOption = options.get(randomIndex)
String selectedText = selectedOption.getText().trim()

println "🎯 Selecting random entry limit: $selectedText"
select.selectByVisibleText(selectedText)

// Nhấn nút Search
WebUI.click(findTestObject('Object Repository/Page_Employees - List  E STAFF/button_Search_btn'))

// Đợi bảng load (có thể điều chỉnh delay hoặc chờ phần tử cụ thể)
WebUI.delay(2)

// Lấy danh sách dòng trong bảng
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> rows = driver.findElements(By.xpath('//*[@id="example"]/tbody/tr'))

// Kiểm tra nếu có dòng "No data"
if (rows.size() == 1 && rows[0].getText().toLowerCase().contains("no data")) {
	println "ℹ️ No data available in table."
	assert true // vẫn pass nếu không có data
} else {
	int expectedLimit = Integer.parseInt(selectedText)
	int actualRows = rows.size()

	println "✅ Total visible rows: $actualRows | Expected max: $expectedLimit"
	assert actualRows <= expectedLimit : "❌ Table shows more rows than expected: $actualRows > $expectedLimit"
}


