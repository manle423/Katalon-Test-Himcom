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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.By


CustomKeywords.'custom.keywords.NavigationActions.navigateToProjectsCategories'()

WebUI.delay(3)

// Bước 2: Lấy danh sách category active từ tab Project Categories

TestObject categoryRowObj = new TestObject()
categoryRowObj.addProperty('xpath', ConditionType.EQUALS, '/html/body/div/div[1]/div/div/div[1]/div[2]/div/table/tbody/tr')

// Lấy tất cả các dòng (tr) trong bảng categories
List<WebElement> categoryRows = WebUiCommonHelper.findWebElements(categoryRowObj, 10)

// Khởi tạo danh sách chứa tên các category có trạng thái 'active'
List<String> categoryNames = []

for (WebElement row : categoryRows) {
	List<WebElement> columns = row.findElements(By.tagName('td'))

	// Giả sử cột 1 là tên, cột 2 là trạng thái
	if (columns.size() >= 2) {
		String name = columns[0].getText().trim()
		String status = columns[1].getText().trim().toLowerCase()

		if (status == 'active') {
			categoryNames.add(name)
		}
	}
}

println('📌 Danh sách category đang Active:')
categoryNames.each { println("🔹 " + it) }
// Bước 3: Mở trang Add Company Project và chọn loại PROJECT
WebUI.click(findTestObject('Page_Dashboard - Analytics  E STAFF/a_CompaniesProjects'))
WebUI.click(findTestObject('Page_CompaniesProjects - List  E STAFF/button_Add_CompanyProject'))

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'PROJECT', false)
WebUI.delay(1) // Đợi form hiển thị lại

// Bước 4: Lấy danh sách checkbox label category ở Add Company Project

TestObject labelObj = new TestObject()
labelObj.addProperty('xpath', ConditionType.EQUALS, '//label[contains(@class, \'form-check-label\')]')

List<WebElement> checkboxElements = WebUiCommonHelper.findWebElements(labelObj, 10)

if (checkboxElements.isEmpty()) {
	KeywordUtil.markFailed('❌ Không tìm thấy checkbox nào ở màn Add Company Project.')
}

List<String> checkboxLabels = checkboxElements.collect { it.getText().trim() }

println("📌 Danh sách category hiển thị ở checkbox:")
checkboxLabels.each { println("🔹 " + it) }

// Bước 5: So sánh 2 danh sách
Set<String> setCategoryNames = new HashSet<>(categoryNames.collect { it.toLowerCase().trim() })
Set<String> setCheckboxLabels = new HashSet<>(checkboxLabels.collect { it.toLowerCase().trim() })

if (setCategoryNames == setCheckboxLabels) {
    println("✅ Hai danh sách hoàn toàn khớp.")
} else {
    println("❌ Hai danh sách KHÔNG khớp.")
    println("🔻 Có trong Categories nhưng không có trong Checkbox: " + (setCategoryNames - setCheckboxLabels))
    println("🔺 Có trong Checkbox nhưng không có trong Categories: " + (setCheckboxLabels - setCategoryNames))
    KeywordUtil.markFailed("❌ Danh sách không khớp.")
}
// Check với các type còn lại

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'COMPANY', false)

WebUI.findWebElement(findTestObject('Page_CompanyProjects - Create  E STAFF/p_Company cant have categories'))

WebUI.verifyElementText(findTestObject('Page_CompanyProjects - Create  E STAFF/p_Company cant have categories'), 'Company can\'t have categories')

WebUI.selectOptionByValue(findTestObject('Page_CompanyProjects - Create  E STAFF/select_Type'), 'MIBSXIRED', false)

WebUI.findWebElement(findTestObject('Page_CompanyProjects - Create  E STAFF/p_Company cant have categories'))

WebUI.verifyElementText(findTestObject('Page_CompanyProjects - Create  E STAFF/p_Company cant have categories'), 'Company can\'t have categories')
WebUI.closeBrowser()