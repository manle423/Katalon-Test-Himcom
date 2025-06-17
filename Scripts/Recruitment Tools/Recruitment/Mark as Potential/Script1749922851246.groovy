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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor


CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

//  Mở bộ lọc trạng thái và nhập tên ứng viên
WebUI.click(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'))
WebUI.setText(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 'nguyễn hồng nga')
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Filter'))
WebUI.delay(2)
//  Scroll ngang đến cột 9 của dòng đầu tiên
WebDriver driver = DriverFactory.getWebDriver()
WebElement targetElement = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]/td[9]'))

((JavascriptExecutor) driver).executeScript('arguments[0].scrollIntoView({block: "center", inline: "center"});', targetElement)

//  Click nút Potential
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Potential'))
WebUI.delay(2)
//  Lọc lại ứng viên sau khi cập nhật trạng thái
WebUI.click(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'))
WebUI.setText(findTestObject('Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 'nguyễn hồng nga')
WebUI.delay(2)
// Xác minh thông báo thành công
WebUI.verifyElementPresent(findTestObject('Page_Candidates by Status  E STAFF/div_Cp nht trng thi thnh Potentail thnh cng'), 5)
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Filter'))

WebElement col9Element = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]/td[9]'))
 
 ((JavascriptExecutor) driver).executeScript(
	 'arguments[0].scrollIntoView({block: "center", inline: "center"});',
	 col9Element
 )
//  Lấy dữ liệu dòng đầu tiên và kiểm tra
WebElement firstRow = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[1]'))
String col8 = firstRow.findElement(By.xpath('td[8]')).getText().trim()
String col9 = firstRow.findElement(By.xpath('td[9]')).getText().trim()

println(" Dòng đầu tiên - Cột 8: ${col8}, Cột 9: ${col9}")

assert col8 == 'Potential' : ' Cột 8 KHÔNG phải Potential!'
assert col9 == 'Potential' : ' Cột 9 KHÔNG phải Potential!'

//  Kết thúc
WebUI.delay(2)
WebUI.closeBrowser()