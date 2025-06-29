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

String skillName = 'John Doe'

CustomKeywords.'custom.keywords.NavigationActions.navigateToSkills'()

WebUI.setText(findTestObject('Page_Skill - List  E STAFF/input_List of skills_search'), skillName)

WebUI.click(findTestObject('Page_Skill - List  E STAFF/button_Search'))

TestObject moreOptionsBtn = findTestObject('Page_Skill - List  E STAFF/button_MoreOptions_SkillName', [('skillName') : skillName])

WebUI.waitForElementVisible(moreOptionsBtn, 10)

WebUI.click(moreOptionsBtn)

WebUI.click(findTestObject('Page_Skill - List  E STAFF/button_Delete'))

WebUI.waitForAlert(5)

WebUI.acceptAlert()

WebUI.verifyTextPresent('Successfully deleted skill', false)

