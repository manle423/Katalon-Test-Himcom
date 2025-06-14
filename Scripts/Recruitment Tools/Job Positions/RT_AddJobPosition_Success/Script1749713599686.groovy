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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

CustomKeywords.'custom.keywords.NavigationActions.navigateToJobPositions'()

WebUI.click(findTestObject('Page_Job Positions - List  E STAFF/button_Add Job'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Create Job Position  E STAFF/select_Select a company'), 
    'Công ty TNHH Perfetti Van Melle (Việt Nam)', false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Create Job Position  E STAFF/select_Select a province'), 
    'Tỉnh Thừa Thiên Huế', false)

// Lấy WebDriver từ Katalon
def driver = DriverFactory.getWebDriver()

// Lấy element dropdown job
WebElement jobDropdown = driver.findElement(By.id('job'))

// Lấy tất cả các option có style hiển thị (không chọn "Select a position")
List<WebElement> visibleOptions = jobDropdown.findElements(By.tagName('option')).findAll({ 
        (it.getAttribute('style').contains('display: block') && (it.getAttribute('value') != null)) && !(it.getAttribute(
            'value').isEmpty())
    })

// Kiểm tra và chọn cái đầu tiên
if (visibleOptions.size() > 0) {
    WebElement firstOption = visibleOptions[0]

    String value = firstOption.getAttribute('value')

    WebUI.comment('👉 Đang chọn option đầu tiên hiển thị: ' + firstOption.getText())

    WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Create Job Position  E STAFF/select_Select a position'), 
        value, false)
} else {
    WebUI.comment('❌ Không có option nào hiển thị để chọn.')
}

WebUI.setText(findTestObject('Page_Create Job Position  E STAFF/input_Number of Positions_num_positions'), '2')

WebUI.click(findTestObject('Page_Create Job Position  E STAFF/button_Submit'))

WebUI.verifyTextPresent('Job position created successfully.', false)

WebUI.closeBrowser()

