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

editProjectCategory('Test Categories 1', 'Final Category 1', 'Not Active')

editProjectCategory('Test Categories 2', null, 'Active')

// Các đoạn kiểm tra cũ
WebUI.verifyTextPresent('Successfully edited category', false)

WebUI.verifyTextNotPresent('Test Categories 1', false)

WebUI.verifyTextPresent('Final Category 1', false)

WebUI.closeBrowser() // ==================== HÀM ====================

def editProjectCategory(String currentName, String newName = null, String newStatus = null) {
    String xpathIcon = "//tr[td[normalize-space()='$currentName']]//i[contains(@class, 'bx-dots-vertical-rounded')]"

    TestObject threeDotsIcon = new TestObject('threeDotsIcon')

    threeDotsIcon.addProperty('xpath', ConditionType.EQUALS, xpathIcon)

    if (WebUI.verifyElementPresent(threeDotsIcon, 10, FailureHandling.OPTIONAL)) {
        WebUI.waitForElementClickable(threeDotsIcon, 10)

        WebUI.click(threeDotsIcon)

        String xpathEdit = "//tr[td[normalize-space()='$currentName']]//a[normalize-space()='Edit']"

        TestObject editBtn = new TestObject('editBtn')

        editBtn.addProperty('xpath', ConditionType.EQUALS, xpathEdit)

        WebUI.waitForElementClickable(editBtn, 10)

        WebUI.click(editBtn)

        if (newName != null) {
            WebUI.waitForElementVisible(findTestObject('Page_Category - Edit  E STAFF/input_Status_catname'), 10)

            WebUI.setText(findTestObject('Page_Category - Edit  E STAFF/input_Status_catname'), newName)
        }
        
        if (newStatus != null) {
            WebUI.waitForElementVisible(findTestObject('Page_Category - Edit  E STAFF/select_Active_Not active'), 10)

            WebUI.selectOptionByValue(findTestObject('Page_Category - Edit  E STAFF/select_Active_Not active'), newStatus == 
                'Active' ? 'true' : 'false', false)
        }
        
        TestObject submitBtn = new TestObject('submitBtn')

        submitBtn.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Submit\']')

        WebUI.waitForElementClickable(submitBtn, 10)

        WebUI.click(submitBtn)

        WebUI.comment("✅ Đã chỉnh sửa '$currentName' thành: '$newName', trạng thái: '$newStatus'")
    } else {
        WebUI.comment("⚠️ Không tìm thấy category '$currentName'")
    }
}

