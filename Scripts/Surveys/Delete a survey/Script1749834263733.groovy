import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import com.kms.katalon.core.webui.driver.DriverFactory
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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory


CustomKeywords.'custom.keywords.LoginActions.login'('admin@gmail.com', 'AdminPass1@')

WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Surveys'))

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/button_Add Survey'))

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/input_Survey Name_survey-name'), 'test 1')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Select Organization_aa6929'),'32', true)

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/textarea_Deactive Content_deactive-content'),'')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Select one status _182459'),'false', true)

WebUI.setText(findTestObject('Object Repository/Page_Survey - Create  E STAFF/textarea_Question Text_form-control'), 'name')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/input_Is this question required_form-check'))
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Survey - Create  E STAFF/select_Choose the question type _5fca1c'), 'text', true)
WebUI.click(findTestObject('Object Repository/Page_Survey - Create  E STAFF/button_Submit'))
WebDriver driver = DriverFactory.getWebDriver()

// Tìm phần tử nút ba chấm (Actions) — bạn có thể điều chỉnh nếu có nhiều dòng
WebElement actionMenuIcon = driver.findElement(By.xpath("//i[contains(@class, 'bx-dots-vertical-rounded')]"))

// Scroll ngang để đưa biểu tượng ba chấm vào tầm nhìn
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({inline: 'center'});", actionMenuIcon)

WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/i_Copy_bx bx-dots-vertical-rounded'))
WebUI.click(findTestObject('Object Repository/Page_Survey - List  E STAFF/button_Delete'))
WebUI.waitForAlert(5 )// wait and accept alter
WebUI.acceptAlert( )
WebUI.delay(1)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Survey - List  E STAFF/div_Succesfully deleted the survey'),  0)
WebUI.delay(1)
WebUI.verifyTextNotPresent('test 1', false)
WebUI.delay(1)
WebUI.closeBrowser()

