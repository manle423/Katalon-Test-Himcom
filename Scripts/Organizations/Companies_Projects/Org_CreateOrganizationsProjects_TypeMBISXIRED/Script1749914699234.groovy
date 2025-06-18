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

// Lấy đường dẫn gốc của project
String projectDir = System.getProperty('user.dir')

// Ghép đường dẫn đến file cần upload
String fileLogoPath = projectDir + '/Upload_File_Sample/CreateOrg_Logo.jpg'

String fileDocPath = projectDir + '/Upload_File_Sample/Test.docx'

String filePDFPath = projectDir + '/Upload_File_Sample/TestPDF.pdf'

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'MIBSXIRED', true)

WebUI.setText(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Organization Name_org-name'), 
    'Test create MIBSXIRED')

WebUI.setText(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Short name (Only for company)_org-shortname'), 
    'ORGABCD1')

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Logo_logo'), fileLogoPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Term_PDF'), filePDFPath)

WebUI.scrollToElement(findTestObject('Page_CompanyProjects - Create  E STAFF/input_SignAgreement_Document'), 0)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Sign Term Document_sign_term'), fileDocPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Agreement_PDF'), filePDFPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_SignAgreement_Document'), fileDocPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Employee Template'), fileDocPath)

WebUI.scrollToElement(findTestObject('Page_CompanyProjects - Create  E STAFF/input_SignAgreement_Document'), 0)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Document 1_documents'), filePDFPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Document 2_documents'), filePDFPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Sign Document 1_signDocuments'), fileDocPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Sign Document 2_signDocuments'), fileDocPath)

WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', null)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/button_Submit'))

WebUI.delay(1)

WebUI.verifyTextPresent('Successfully created organization', false)

WebUI.findWebElement(findTestObject('Page_CompaniesProjects - List  E STAFF/i_Active_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Page_CompaniesProjects - List  E STAFF/i_Active_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_CompaniesProjects - List  E STAFF/button_Delete'))

WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyTextPresent('Successfully deleted organization', false)

WebUI.closeBrowser()

