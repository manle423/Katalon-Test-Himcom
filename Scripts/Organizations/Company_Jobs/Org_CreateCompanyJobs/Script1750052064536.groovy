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

CustomKeywords.'custom.keywords.NavigationActions.navigateToCompanyJobs'()


WebUI.click(findTestObject('Object Repository/Page_Company Jobs - List  E STAFF/span_Add                            Job'))

WebUI.setText(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/input_Action_form-control'), '1Test Job 1')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/select_Select a company                    _2448fd'), 
    '45', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/select_Select a status                     _11e55a'), 
    'false', true)

WebUI.click(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/button_Add Job'))

WebUI.setText(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/input_Action_form-control_1'), 'Test Job 2')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/select_Select a company                    _2448fd_1'), 
    '31', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/select_Select a status                     _11e55a_1'), 
    'false', true)

WebUI.click(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/button_Action_btn btn-danger'))

WebUI.click(findTestObject('Object Repository/Page_Company Job - Create  E STAFF/button_Submit'))

WebUI.click(findTestObject('Object Repository/Page_Company Jobs - List  E STAFF/div_Succesfully created jobs'))

WebUI.closeBrowser()

