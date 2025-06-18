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

CustomKeywords.'custom.keywords.NavigationActions.navigateToOrgWorkships'()

WebUI.click(findTestObject('Page_Workshifts - List  E STAFF/span_Add Workshifts'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/select_Choose an organization              _f3d3c5'), 
    '32', true)

WebUI.setText(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/input_End Date_workshift1name'), 'Test 1')
WebUI.click(findTestObject('Page_Workshift - Create  E STAFF/input_End Date_workshift1startDate'))

WebUI.executeJavaScript(
    "document.querySelector('input[name=\"workshift[1][endDate]\"]').value = '2025-06-17';", null)
WebUI.click(findTestObject('Page_Workshift - Create  E STAFF/input_End Date_workshift1endDate'))

WebUI.executeJavaScript(
	"document.querySelector('input[name=\"workshift[1][startDate]\"]').value = '2025-06-17';", null)

WebUI.click(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/button_Add WorkShift'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/select_Choose an organizationTesting for He_e4d2d0'), 
    '32', true)

WebUI.click(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/i_End Date_bx bx-trash me-1 fs-4 delete-workshift'))

WebUI.click(findTestObject('Object Repository/Page_Workshift - Create  E STAFF/button_Submit'))

WebUI.closeBrowser()

