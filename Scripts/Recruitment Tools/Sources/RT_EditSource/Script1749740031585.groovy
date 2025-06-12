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

String sourceName = 'Source99'

CustomKeywords.'custom.keywords.NavigationActions.navigateToSources'()

WebUI.setText(findTestObject('Page_Source - List  E STAFF/input_List of sources_search'), sourceName)

WebUI.click(findTestObject('Page_Source - List  E STAFF/button_Search'))

TestObject moreOptionsBtn = findTestObject('Page_Source - List  E STAFF/button_MoreOptions_BySourceName', [('sourceName') : sourceName])

WebUI.waitForElementVisible(moreOptionsBtn, 10)

WebUI.click(moreOptionsBtn)

WebUI.click(findTestObject('Page_Source - List  E STAFF/a_Edit'))

WebUI.setText(findTestObject('Page_Source - Edit  E STAFF/input_Source Name_source-name'), 'Source 99 updated')

WebUI.click(findTestObject('Page_Source - Edit  E STAFF/button_Submit'))

WebUI.verifyTextPresent('Successfully updated source', false)

