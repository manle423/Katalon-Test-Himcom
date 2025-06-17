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

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeeTemporaryEmployees'()

WebUI.setText(findTestObject('Page_Projects - List  E STAFF/input_Search by project name_search'), 'Testing for Herbalife')

WebUI.click(findTestObject('Page_Projects - List  E STAFF/button_Search by project name_btn'))

WebUI.verifyTextPresent('Testing for Herbalife', false)

WebUI.click(findTestObject('Page_Projects - List  E STAFF/button_View Employee'))

WebUI.verifyTextPresent('List of Temporary Employees', false)

WebUI.click(findTestObject('Object Repository/Page_Temp Employees - List  E STAFF/i_Agreement_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Temp Employees - List  E STAFF/a_Edit'))

WebUI.verifyTextPresent('Edit Employee', false)

