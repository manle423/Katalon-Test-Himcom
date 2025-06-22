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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://nhanvien-test.estaff.vn/admin/login')

WebUI.setText(findTestObject('Object Repository/Page_Admin Login Page  E STAFF/input_Email_email'), 'admin@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Admin Login Page  E STAFF/input_Password_password'), '2uPS/iW+EvdSWEXxuvdC2g==')

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

WebUI.setText(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    'Cao Thị Tiên')

WebUI.sendKeys(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_candidate-checkbox'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/span_More actions'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Approve'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/select_-- Select next round --             _51537b'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Cp nht'))

