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

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/span_Add Survey'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Select Organization_aa6929'), 
    '21', true)

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/input_Survey Name_survey-name'), 'Test Add Survey')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Select one status _182459'), 
    'true', true)

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/textarea_Deactive Content_deactive-content'), 
    'Due date')

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/textarea_Question Text_form-control'), 'Your name?')

WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/input_Is this question required_form-check'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Choose the question type _5fca1c'), 
    'text', true)

WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/button_Add Question'))

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/textarea_Question Text_form-control_1'), 'Your age?')

WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/label_Question Text'))

WebUI.click(findTestObject('Page_Survey - Create  E STAFF/input_Required_form-check-input border'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Choose the question type_5fca1c_1'), 
    'number', true)

WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/button_Submit'))

String nameText = 'Test Add Survey'

String activeStatus = 'Active'

String organization = 'Công ty TNHH HIMCOM'

// XPath tìm dòng đầu tiên chứa cả hai đoạn text
String xpath = "//table[@class='table table-hover']//tr[contains(@class,'text-nowrap')][td[contains(.,'$nameText')] and td[contains(.,'$activeStatus')] and td[contains(.,'$organization')]]"

TestObject rowCheck = new TestObject()

rowCheck.addProperty('xpath', ConditionType.EQUALS, xpath)

WebUI.verifyElementPresent(rowCheck, 10)

WebUI.verifyTextPresent('Succesfully created the survey', false)

WebUI.closeBrowser()

