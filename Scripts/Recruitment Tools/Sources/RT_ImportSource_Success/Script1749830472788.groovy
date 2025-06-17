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

CustomKeywords.'custom.keywords.NavigationActions.navigateToSources'()

WebUI.click(findTestObject('Page_Reason - List  E STAFF/div_More actions'))

WebUI.click(findTestObject('Page_Source - List  E STAFF/a_Import data'))

//WebUI.click(findTestObject('Page_Source - List  E STAFF/input_Upload CSV file_file'))
String filePath = 'C:\\Users\\CanhThieng\\Downloads\\source_import_template.xlsx'

WebUI.uploadFile(findTestObject('Page_Source - List  E STAFF/input_Upload CSV file_file'), filePath)

WebUI.click(findTestObject('Page_Source - List  E STAFF/button_Import'))

WebUI.verifyTextPresent('Import successful.', false)

