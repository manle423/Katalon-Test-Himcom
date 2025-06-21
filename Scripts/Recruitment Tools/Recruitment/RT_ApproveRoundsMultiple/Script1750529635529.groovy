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
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil


CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)
WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))
WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Applied'))

// Đợi table load
WebUI.delay(2) // hoặc dùng waitForElementVisible nếu cần

String nameXpath = "//table[@id='example']//td[contains(@class,'candidate-hover')]"
List<WebElement> appliedElements = DriverFactory.getWebDriver().findElements(By.xpath(nameXpath))

List<String> appliedCandidateNames = []
for (WebElement e : appliedElements) {
    appliedCandidateNames.add(e.getText().trim())
}

def clickAndApproveRound(String nextRoundValue) {
    TestObject approveBtn = findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Approve')
    TestObject selectDropdown = findTestObject('Object Repository/Page_Candidates by Status  E STAFF/select_-- Select next round --             _51537b')
    TestObject updateBtn = findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Cp nht')

    WebUI.waitForElementVisible(approveBtn, 10)
    WebUI.scrollToElement(approveBtn, 5)
    WebUI.waitForElementClickable(approveBtn, 10)
    WebUI.click(approveBtn)

    WebUI.waitForElementVisible(selectDropdown, 10)
    WebUI.selectOptionByValue(selectDropdown, nextRoundValue, true)

    WebUI.waitForElementClickable(updateBtn, 10)
    WebUI.click(updateBtn)
}

// Round 2
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/div_More actions'))
clickAndApproveRound('2')

// Round 2 again
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Prescreened'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/div_More actions'))
clickAndApproveRound('3')

// Round 4
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_1st Interview'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/span_More actions'))
clickAndApproveRound('4')

// Round 5
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_2nd Interview'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/div_More actions'))
clickAndApproveRound('5')

// Round 6
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Offer'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/span_More actions'))
clickAndApproveRound('6')

// Round 7
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Probation'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_checkAll'))
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/i_Import PDF_bx bx-dots-vertical-rounded'))
clickAndApproveRound('7')

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Hired'))

WebUI.delay(2) // Đợi dữ liệu load

List<WebElement> hiredElements = DriverFactory.getWebDriver().findElements(By.xpath(nameXpath))

List<String> hiredCandidateNames = []
for (WebElement e : hiredElements) {
    hiredCandidateNames.add(e.getText().trim())
}

// So sánh và ghi log kết quả
for (String name : appliedCandidateNames) {
    if (hiredCandidateNames.contains(name)) {
        KeywordUtil.logInfo("✅ Candidate '${name}' was successfully approved to Hired round.")
    } else {
        KeywordUtil.markWarning("⚠️ Candidate '${name}' not found in Hired round.")
    }
}

WebUI.closeBrowser()


