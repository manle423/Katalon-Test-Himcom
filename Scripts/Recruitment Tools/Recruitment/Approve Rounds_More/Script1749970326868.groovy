
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

WebUI.click(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'))

WebUI.setText(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 'nguyễn hồng nga')

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Filter'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Filter'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_candidate-checkbox'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/div_More actions'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Approve'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/select_-- Select next round -- _51537b'),
	'3', true)

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Cp nht'))

WebDriver driver = DriverFactory.getWebDriver()

// Scroll ngang đến cột 8 của dòng 1
WebElement col8 = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]/td[8]'))
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({inline: 'center'});", col8)

// Scroll dọc đến dòng 1
WebElement row1 = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]'))
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", row1)

WebUI.delay(1)

// Lấy nội dung cột 8
WebElement firstRow = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]'))
String col8Text = firstRow.findElement(By.xpath('td[8]')).getText().trim()

println("📌 Dòng 1 - Cột 8: ${col8Text}")

assert col8Text == '1st Interview' : "❌ Nội dung không đúng. Thực tế: '${col8Text}'"

WebUI.verifyElementPresent(findTestObject('Page_Candidates by Status  E STAFF/div_Cp nht vng tip theo ca ng vin thnh cng'),
	0)

WebUI.delay(2)

WebUI.closeBrowser()


