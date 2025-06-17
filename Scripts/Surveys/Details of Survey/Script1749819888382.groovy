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

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Surveys'))

WebUI.setText(findTestObject('Object Repository/Page_Survey - List  E STAFF/input_Search_search'), 'PVM')

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/span'))

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/i_Copy_bx bx-dots-vertical-rounded'))

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/a_View'))

List<String> expectedTexts = ['Detail of Survey', 'NAME: PVM Shopper Incentive25 | CHƯƠNG TRÌNH TRẢ THƯỞNG 5% -10% DÀNH CHO KHÁCH HÀNG'
    , 'COVER IMAGE:', 'ORGANIZATION:', 'BACKGROUND IMAGE:', 'STATUS:', 'DEACTIVE CONTENT: Chương trình chiết khấu 5%-10% của Perffti Van Melle chính thức khép lại, cảm ơn quý khách hàng đã quan tâm và tham gia trong thời gian qua. Các thông tin quý khách hàng đăng ký trước ngày 27/01/2025 vẫn sẽ được bộ phận trả thưởng tiếp nhận và xử lý. Trân trọng cảm ơn!'
    ,'Step 1']

for (String text : expectedTexts) {
    WebUI.verifyTextPresent(text, false)
}

WebUI.closeBrowser()

