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

CustomKeywords.'custom.keywords.NavigationActions.navigateToOrganizationsProjects'()

WebUI.click(findTestObject('Page_CompaniesProjects - List  E STAFF/button_Add_CompanyProject'))

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'PROJECT', false)

WebUI.verifyElementNotClickable(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Short name (Only for company)_org-shortname'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/select_Type'), 'COMPANY', 
    false)

WebUI.setText(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Short name (Only for company)_org-shortname'), 
    'abcs')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/select_Type'), 'MIBSXIRED', 
    false)

WebUI.setText(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Short name (Only for company)_org-shortname'), 
    'ahduew')

WebUI.closeBrowser()

