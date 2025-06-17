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

WebUI.openBrowser('https://nhanvien.estaff.vn/admin/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_Admin Login Page  E STAFF/input_Email_email'), email)

WebUI.setText(findTestObject('Page_Admin Login Page  E STAFF/input_Password_password'), password)

WebUI.click(findTestObject('Page_Admin Login Page  E STAFF/i_Password_bx bx-hide'))

WebUI.click(findTestObject('Page_Admin Login Page  E STAFF/button_Sign in'))

// In ra kết quả mong đợi để debug
println('Expected Result: ' + expected_result)

// Tach nhieu đoan text ngan cach boi dau |
String[] expectedTexts = expected_result.split('\\s*\\|\\s*')

// Kiểm tra từng đoạn text có xuất hiện trên màn hình
for (String txt : expectedTexts) {
    println('Checking text: ' + txt)

    WebUI.verifyTextPresent(txt.trim(), false)
}
WebUI.delay(3)
WebUI.closeBrowser()

