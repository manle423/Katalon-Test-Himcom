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
// Lấy đường dẫn gốc của project
// Ghép đường dẫn đến file cần upload
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'custom.keywords.NavigationActions.navigateToOrganizationsProjects'()

WebUI.click(findTestObject('Page_CompaniesProjects - List  E STAFF/button_Add_CompanyProject'))

String projectDir = System.getProperty('user.dir')

String fileLogoPath = projectDir + '/Upload_File_Sample/CreateOrg_Logo.jpg'

String fileDocPath = projectDir + '/Upload_File_Sample/Test.docx'

String filePDFPath = projectDir + '/Upload_File_Sample/TestPDF.pdf'

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'PROJECT', true)

WebUI.setText(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Organization Name_org-name'), 
    'Test create project')

WebUI.verifyElementNotClickable(findTestObject('Object Repository/Page_CompanyProjects - Create  E STAFF/input_Short name (Only for company)_org-shortname'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Logo_logo'), fileLogoPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Term_PDF'), filePDFPath)

//WebUI.scrollToElement(findTestObject('Page_CompanyProjects - Create  E STAFF/input_SignAgreement_Document'), 0)
WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Sign Term Document_sign_term'), fileDocPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Preview Agreement_PDF'), filePDFPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_SignAgreement_Document'), fileDocPath)

WebUI.uploadFile(findTestObject('Page_CompanyProjects - Create  E STAFF/input_Employee Template'), fileDocPath)

//WebUI.scrollToElement(findTestObject('Page_CompanyProjects - Create  E STAFF/h4_Categories'), 0)
WebUI.findWebElement(findTestObject('Page_CompanyProjects - Create  E STAFF/div_categories_checkbox'))

//// Tạo đối tượng TestObject để tìm tất cả checkbox trong #cat-list
//TestObject checkboxInCatList = new TestObject()
//
//checkboxInCatList.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'cat-list\']//input[@type=\'checkbox\']')
// Tìm tất cả checkbox trong div
TestObject checkboxObj = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'cat-list\']//input[@type=\'checkbox\']')

List<WebElement> checkboxes = WebUiCommonHelper.findWebElements(checkboxObj, 10)

Random rand = new Random()

if (!(checkboxes.isEmpty())) {
    for (WebElement checkbox : checkboxes) {
        // 50% cơ hội để chọn mỗi checkbox
        if (rand.nextBoolean()) {
            if (!(checkbox.isSelected())) {
                checkbox.click()
            }
        }
    }
}

WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
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

