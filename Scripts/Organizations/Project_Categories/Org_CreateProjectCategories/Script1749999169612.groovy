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

CustomKeywords.'custom.keywords.NavigationActions.navigateToProjectsCategories'()

WebUI.click(findTestObject('Object Repository/Page_Categories - List  E STAFF/span_Add Category'))

WebUI.click(findTestObject('Object Repository/Page_Category - Create  E STAFF/input_Status_cat1name'))

WebUI.setText(findTestObject('Object Repository/Page_Category - Create  E STAFF/input_Status_cat1name'), 'Test Categories 1')

WebUI.click(findTestObject('Object Repository/Page_Category - Create  E STAFF/button_Add Categories'))

WebUI.setText(findTestObject('Object Repository/Page_Category - Create  E STAFF/input_Status_cat2name'), 'Test Categories 2')

WebUI.click(findTestObject('Page_Category - Create  E STAFF/button_Add Categories'))

WebUI.setText(findTestObject('Page_Category - Create  E STAFF/input_Status_cat3name'), 'Test Categories 3')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Category - Create  E STAFF/select_ActiveNot Active'), 'false', 
    true)

WebUI.click(findTestObject('Page_Category - Create  E STAFF/i_Status_bx bx-trash me-1 fs-4 delete-cat'))

WebUI.click(findTestObject('Object Repository/Page_Category - Create  E STAFF/button_Submit'))

WebUI.verifyTextPresent('Successfully created categories', false)

WebUI.verifyTextPresent('Test Categories 1', false)

WebUI.verifyTextPresent('Test Categories 2', false)

WebUI.verifyTextNotPresent('Test Categories 3', false)

WebUI.closeBrowser()

