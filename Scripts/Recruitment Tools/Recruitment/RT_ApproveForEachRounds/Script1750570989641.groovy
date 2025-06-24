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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.scrollToElement(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'), 5)

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment Tools'))

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Recruitment'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Applied'))

// 2. Duyệt các vòng tuyển dụng và approve
String candidateName = 'Cao Thị Tiên'

List<String> recruitmentRounds = ['Applied', 'Prescreened', '1st Interview', '2nd Interview', 'Offer', 'Probation', 'Hired']

for (String round : recruitmentRounds) {
    WebUI.setText(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
        candidateName)

    WebUI.sendKeys(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
        Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_' + round))

    TestObject approveBtn = findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Approve')

    if (WebUI.verifyElementPresent(approveBtn, 5, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(approveBtn, 3)
        WebUI.delay(1)
        WebUI.click(approveBtn)

        // ✅ Verify round column (8th column) after approve
        WebUI.delay(2) // đợi dữ liệu update sau khi approve

        TestObject roundCol = new TestObject().addProperty(
            'xpath',
            ConditionType.EQUALS,
            "//table[@id='example']//td[4][normalize-space(text())='${candidateName}']/following-sibling::td[4][normalize-space(text())='${round}']"
        )

        if (WebUI.verifyElementPresent(roundCol, 5, FailureHandling.OPTIONAL)) {
            println("✅ Candidate [$candidateName] correctly moved to round [$round].")
        } else {
            println("❌ Candidate [$candidateName] not showing in round [$round] (column 8 check failed).")
        }
    }
}

// 3. Kiểm tra vòng Hired
WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/h6_Hired'))

WebUI.setText(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    candidateName)

WebUI.sendKeys(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    Keys.chord(Keys.ENTER))

TestObject candidateInHired = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//table[@id=\'example\']//td[4][normalize-space(text())=\'' + 
    candidateName) + '\']')

if (WebUI.verifyElementPresent(candidateInHired, 5, FailureHandling.OPTIONAL)) {
    println("✅ Candidate [$candidateName] has reached the Hired stage.")
} else {
    println("❌ Candidate [$candidateName] not found in Hired stage.")
}

// 4. Đưa ứng viên về lại vòng Applied
WebUI.setText(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    candidateName)

WebUI.sendKeys(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Select a Job Postion_search'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/input_Potential_candidate-checkbox'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/span_More actions'))

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Approve_in_more_action'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/select_-- Select next round --             _51537b'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/Page_Candidates by Status  E STAFF/button_Cp nht'))

println("🔄 Candidate [$candidateName] has been reset to Applied for the next test run.")

WebUI.closeBrowser()

