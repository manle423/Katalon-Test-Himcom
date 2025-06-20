package custom.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class NavigationActions {
	def navigateToJobPositions() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Job Positions'))
		WebUI.verifyTextPresent('List of Job Positions', false)
	}

	def navigateToDashBoard() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Dashboard'))
		WebUI.verifyTextPresent('Active Jobs', false)
	}

	def navigateToRecruitment() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Recruitment'))
		WebUI.verifyTextPresent('Candidates by Interview Status', false)
	}

	def navigateToSources() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/div_Sources'))
		WebUI.verifyTextPresent('List of sources', false)
	}

	def navigateToReasons() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Skill - List  E STAFF/a_Reasons'), 5)
		WebUI.click(findTestObject('Object Repository/Page_Skill - List  E STAFF/a_Reasons'))
		WebUI.verifyTextPresent('List of reasons', false)
	}

	def navigateToSkills() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Skills'), 5)
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Skills'))
		WebUI.verifyTextPresent('List of skills', false)
	}

	def navigateToSkillGroups() {
		navigateToSkills()
		WebUI.click(findTestObject('Page_Skill - List  E STAFF/div_More actions'))
		WebUI.click(findTestObject('Page_Skill - List  E STAFF/a_View Skill Groups'))
		WebUI.verifyTextPresent('List of skill groups', false)
	}

	def navigateToJobIndustries() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_Recruitment Tools'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Job Industries'), 5)
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/div_Job Industries'))
		WebUI.verifyTextPresent('List of Job Industries', false)
	}

	def navigateToEmployeesGeneralInformation() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Employees'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Employees - List  E STAFF/div_General Information'), 5)
		WebUI.click(findTestObject('Page_Employees - List  E STAFF/a_General Information'))
		WebUI.verifyTextPresent('Employees General Information', false)
	}

	def navigateToEmployeePermanentEmployees() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Employees'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Employees - List  E STAFF/a_Permanent Employees'), 5)
		WebUI.click(findTestObject('Page_Employees - List  E STAFF/a_Permanent Employees'))
		WebUI.verifyTextPresent('Choose Company', false)
	}

	def navigateToEmployeeTemporaryEmployees() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Employees'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Employees - List  E STAFF/a_Temporary Employees'), 5)
		WebUI.click(findTestObject('Object Repository/Page_Employees - List  E STAFF/a_Temporary Employees'))
		WebUI.verifyTextPresent('Choose a Project', false)
	}

	def navigateToEmployeeMbisEmployees() {
		new LoginActions().login('admin@gmail.com', 'AdminPass1@')
		WebUI.click(findTestObject('Object Repository/Page_Dashboard - Analytics  E STAFF/a_Employees'))
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Employees - List  E STAFF/a_MIBS x iRED Employees'), 5)
		WebUI.click(findTestObject('Object Repository/Page_Employees - List  E STAFF/a_MIBS x iRED Employees'))
		WebUI.click(findTestObject('Object Repository/Page_Companies - List  E STAFF/button_View Employee'))
		WebUI.verifyTextPresent('List of MibsXiRed Employees', false)
	}
}
