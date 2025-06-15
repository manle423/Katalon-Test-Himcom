import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.support.ui.Select as Select
import java.util.Random as Random
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
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

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeesGeneralInformation'()

WebElement dropdown = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Page_Employees - List  E STAFF/select_Select'),
	10)

Select select = new Select(dropdown)

// Lấy tất cả options (bỏ qua option đầu tiên nếu là placeholder như "Select")
List<WebElement> options = select.getOptions()

int randomIndex = new Random().nextInt(options.size() - 1) + 1 // từ index 1 trở đi

String selectedText = (options[randomIndex]).getText()

select.selectByIndex(randomIndex)

WebUI.comment("Đã chọn company ngẫu nhiên: $selectedText")

WebUI.click(findTestObject('Page_Employees - List  E STAFF/button_Search_btn'))

WebUI.verifyTextPresent('Employees General Information', false)

WebUI.closeBrowser()



