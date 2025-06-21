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

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

WebUI.waitForElementVisible(findTestObject('Page_Candidates by Status  E STAFF/h4_Candidates by Interview Status'), 0)

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/div_All'))

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/div_All _ _31db68'))

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/div_Import Actions_Import_PDF_Import Exc'))

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/ul_All_Applied'))

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/ul_All _16b2f9'))

WebUI.verifyElementVisible(findTestObject('Page_Candidates by Status  E STAFF/h4_Candidates by Interview Status'))

WebUI.delay(2)

WebUI.closeBrowser()

