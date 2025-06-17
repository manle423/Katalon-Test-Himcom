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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Surveys'))

WebUI.setText(findTestObject('SurveyList_Create/Page_Survey - List  E STAFF/input_Search_search'), 'PVM')

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/i_Search_bx bx-search me-sm-1'))

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/i_Copy_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/button_Proccessed'))

WebUI.verifyTextPresent('Succesfully change the processed status of the survey', false)

String nameText = 'PVM Shopper Incentive25 | CHƯƠNG TRÌNH TRẢ THƯỞNG 5% -10% DÀNH CHO KHÁCH HÀNG'

String processedText = 'Processed'

// XPath tìm dòng đầu tiên chứa cả hai đoạn text
String xpath = "//table[@class='table table-hover']//tr[contains(@class,'text-nowrap')][td[contains(.,'$nameText')] and td[contains(.,'$processedText')]]"

TestObject rowCheck = new TestObject()

rowCheck.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.verifyElementPresent(rowCheck, 10)

WebUI.click(findTestObject('Page_Survey - List  E STAFF/i_Copy_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Page_Survey - List  E STAFF/button_Not Proccessed'))

WebUI.verifyTextPresent('Succesfully change the processed status of the survey', false)

String notProcessedText = 'NOT PROCESSED'

// XPath tìm dòng đầu tiên chứa cả hai đoạn text
String xpath1 = "//table[@class='table table-hover']//tr[contains(@class,'text-nowrap')][td[contains(.,'$nameText')] and td[contains(.,'$notProcessedText')]]"

TestObject rowCheck1 = new TestObject()

rowCheck1.addProperty('xpath', ConditionType.EQUALS, xpath1)

WebUI.verifyElementPresent(rowCheck, 10)

WebUI.closeBrowser()

