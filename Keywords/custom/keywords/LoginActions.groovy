package custom.keywords

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

public class LoginActions {
	@Keyword
	def login(String email, String password) {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://nhanvien-test.estaff.vn/admin/login')
		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Object Repository/Page_Admin Login Page  E STAFF/input_Email_email'), email)
		WebUI.setText(findTestObject('Object Repository/Page_Admin Login Page  E STAFF/input_Password_password'), password)

		WebUI.click(findTestObject('Object Repository/Page_Admin Login Page  E STAFF/button_Sign in'))

		WebUI.verifyTextPresent('Welcome Back!', false)
	}
}
