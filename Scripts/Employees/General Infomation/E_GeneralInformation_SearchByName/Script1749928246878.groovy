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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Arrays as Arrays
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

String employeeName = 'Tôn Nữ Bảo Trâm'

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeesGeneralInformation'()

WebUI.setText(findTestObject('Page_Employees - List  E STAFF/input_Search_search'), employeeName)
WebUI.click(findTestObject('Page_Employees - List  E STAFF/button_Search_btn'))
WebUI.verifyTextPresent(employeeName, false)
WebDriver driver = DriverFactory.getWebDriver()
WebElement row = driver.findElement(By.xpath('//table//tbody/tr'))
String identifier = row.findElement(By.xpath('td[1]')).getText().trim()
String idBackLink = row.findElement(By.xpath('td[3]/a')).getAttribute('href').trim()
String fullName = row.findElement(By.xpath('td[4]')).getText().trim()
String email = row.findElement(By.xpath('td[5]')).getText().trim()
String dob = row.findElement(By.xpath('td[6]')).getText().trim()
String gender = row.findElement(By.xpath('td[7]')).getText().trim()
println('📋 Table Data:')
println("$identifier | $idBackLink | $fullName | $email | $dob | $gender")
WebUI.waitForElementClickable(findTestObject('Page_Employees - List  E STAFF/i_Male_bx bx-dots-vertical-rounded'), 5)
WebUI.click(findTestObject('Page_Employees - List  E STAFF/i_Male_bx bx-dots-vertical-rounded'))
WebUI.delay(1.5)
String viewXPath = '//a[contains(@class, \'dropdown-item\') and contains(., \'View\')]'
TestObject viewBtn = new TestObject().addProperty('xpath', ConditionType.EQUALS, viewXPath)
int retry = 0
boolean found = false
while ((retry < 5) && !(found)) {
    try {
        WebElement el = WebUiCommonHelper.findWebElement(viewBtn, 2)

        if ((el != null) && el.isDisplayed()) {
            found = true

            WebUI.click(viewBtn)

            println('✅ Clicked View')

            break
        }
    }
    catch (Exception ex) {
        WebUI.delay(1)

        retry++
    } 
}

if (!(found)) {
    throw new Exception('❌ Không tìm thấy nút View sau khi mở menu dropdown!')
}

WebUI.verifyTextPresent(identifier, false)
WebUI.verifyTextPresent(fullName, false)
WebUI.verifyTextPresent(email, false)
WebUI.verifyTextPresent(dob, false)
WebUI.verifyTextPresent(gender, false)

