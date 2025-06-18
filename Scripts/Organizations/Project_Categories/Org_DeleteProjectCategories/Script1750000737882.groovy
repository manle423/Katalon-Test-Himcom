import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'custom.keywords.NavigationActions.navigateToProjectsCategories'()

// Hàm xóa category theo tên
// Nếu có confirm popup
// Chờ DOM reload
// Gọi xóa từng category
deleteCategoryByName('Final Category 1')

deleteCategoryByName('Test Categories 2')

WebUI.verifyTextPresent('Successfully deleted category', false)

WebUI.verifyTextNotPresent('Final Category 1', false)

WebUI.verifyTextNotPresent('Test Categories 2', false)

WebUI.closeBrowser()

def deleteCategoryByName(String categoryName) {
    String xpathIcon = ('//tr[td[text()=\'' + categoryName) + '\']]//i[contains(@class, \'bx-dots-vertical-rounded\')]'

    TestObject threeDotsIcon = new TestObject('dynamicIcon')

    threeDotsIcon.addProperty('xpath', ConditionType.EQUALS, xpathIcon)

    if (WebUI.verifyElementPresent(threeDotsIcon, 10, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(threeDotsIcon, 10)

        WebUI.click(threeDotsIcon)

        TestObject deleteBtn = new TestObject('deleteBtn')

        String xpathDelete = ('//tr[td[normalize-space()=\'' + categoryName) + '\']]//button[normalize-space()=\'Delete\']'

        deleteBtn.addProperty('xpath', ConditionType.EQUALS, xpathDelete)

        WebUI.waitForElementClickable(deleteBtn, 10)

        WebUI.click(deleteBtn)

        if (WebUI.waitForAlert(3, FailureHandling.OPTIONAL)) {
            WebUI.acceptAlert()
        }
        
        WebUI.comment('✅ Đã xóa category: ' + categoryName)

        WebUI.delay(1)
    } else {
        WebUI.comment('⚠️ Không tìm thấy category có tên: ' + categoryName)
    }
}

