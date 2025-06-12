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

String jobName = 'PVM Vietnam1.Thừa Thiên Huế.test1'

CustomKeywords.'custom.keywords.NavigationActions.navigateToJobPositions'()

WebUI.waitForElementVisible(findTestObject('Page_Job Positions - List  E STAFF/button_MoreOptions_ByJobName', [('jobName') : jobName]), 
    10)

WebUI.click(findTestObject('Page_Job Positions - List  E STAFF/button_MoreOptions_ByJobName', [('jobName') : jobName]))

WebUI.waitForElementClickable(findTestObject('Page_Job Positions - List  E STAFF/button_Delete_JobPosition_ByJobName', [
            ('jobName') : jobName]), 10)

WebUI.click(findTestObject('Page_Job Positions - List  E STAFF/button_Delete_JobPosition_ByJobName', [('jobName') : jobName]))

WebUI.waitForAlert(5)

WebUI.acceptAlert()

WebUI.acceptAlert()

WebUI.verifyTextNotPresent(jobName, false)

