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

CustomKeywords.'custom.keywords.LoginActions.login'('adminTest@gmail.com', 'AdminPass1@')

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Organizations'), 0)

// Kiểm tra sự hiện diện
WebUI.verifyTextPresent('Recruitment Tools', false)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Employees'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Admin Accounts'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Chains'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Banks'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Miscellaneous'), 0)

WebUI.closeBrowser()

