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

CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Admin Accounts'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Admin Accounts'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/div_List of Admin_Create ad_849ba1'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/i_Admin_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/a_View'))
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_Admin Accounts - View  E STAFF/a_Admin Accounts'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/i_Admin_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/a_Edit'))

WebUI.click(findTestObject('Object Repository/Page_Admin - Edit  E STAFF/input_Organizations_organizations'))

WebUI.click(findTestObject('Object Repository/Page_Admin - Edit  E STAFF/input_projects_permissions'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_Admin - Edit  E STAFF/button_Submit'), 5)

WebUI.click(findTestObject('Object Repository/Page_Admin - Edit  E STAFF/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Admin Accounts - View  E STAFF/div_Successfully edited account'), 
    0)

WebUI.click(findTestObject('Object Repository/Page_Admin Accounts - View  E STAFF/a_Admin Accounts'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/i_Admin_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Admins - List  E STAFF/a_View'))

WebUI.delay(4)

WebUI.closeBrowser()

