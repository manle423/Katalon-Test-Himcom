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

String skillGroupName = 'Name'

CustomKeywords.'custom.keywords.NavigationActions.navigateToSkillGroups'()

WebUI.setText(findTestObject('Page_Skill Group- List  E STAFF/input_List of skill groups_search'), skillGroupName)

WebUI.click(findTestObject('Page_Skill Group- List  E STAFF/button_Search'))

TestObject moreOptionsBtn = findTestObject('Page_Skill Group- List  E STAFF/button_MoreOptions_BySkillGroupName', [('skillGroupName') : skillGroupName])

WebUI.waitForElementVisible(moreOptionsBtn, 10)

WebUI.click(moreOptionsBtn)

WebUI.click(findTestObject('Page_Skill Group- List  E STAFF/button_Delete', [('skillGroupName') : skillGroupName]))

WebUI.waitForAlert(5, FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Successfully deleted skill group', false)

