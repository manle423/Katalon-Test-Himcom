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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor

CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/select_Select Candidate Status_26b62e'), 
    'waiting', true)

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Filter'))

WebDriver driver = DriverFactory.getWebDriver()

WebElement row2 = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[2]'))
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", row2)

WebUI.delay(1) 

// Scroll ngang đến cột 9 của dòng 2
WebElement col9InRow2 = driver.findElement(By.xpath('//*[@id="example"]/tbody/tr[2]/td[9]'))
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({inline: 'center'});", col9InRow2)

// Lấy tất cả các dòng trong bảng
List<WebElement> rows = driver.findElements(By.xpath('//*[@id="example"]/tbody/tr'))

// Kiểm tra từng dòng
int rowIndex = 1

for (WebElement row : rows) {
    String col9 = row.findElement(By.xpath('td[9]')).getText().trim()

    println("Dòng $rowIndex - Cột 9: $col9")

    assert col9 == 'Waiting'

    rowIndex++
}

println('Status: \'Waiting\'')

WebUI.delay(2)

WebUI.closeBrowser()

