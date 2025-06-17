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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.util.Random as Random

CustomKeywords.'custom.keywords.NavigationActions.navigateToRecruitment'()

// Click mở dropdown Select2
WebUI.waitForElementVisible(findTestObject('Page_Candidates by Status  E STAFF/select_jobPosition'), 10)
WebUI.click(findTestObject('Page_Candidates by Status  E STAFF/select_jobPosition'))

// Lấy driver
WebDriver driver = DriverFactory.getWebDriver()
WebUI.delay(1)

// Lấy tất cả các option
List<WebElement> options = driver.findElements(By.xpath("//li[contains(@class,'select2-results__option') and not(contains(@class, 'select2-results__message'))]"))

String fullJobTitle = ''
String expectedPosition = ''

if (options.size() > 0) {
    Random rand = new Random()
    int index = rand.nextInt(options.size())
    WebElement randomOption = options.get(index)
    
    fullJobTitle = randomOption.getText().trim()
    println "🎯 Selected: $fullJobTitle"

    // Trích phần 'vị trí' sau dấu chấm cuối cùng
    if (fullJobTitle.contains('.')) {
        expectedPosition = fullJobTitle.substring(fullJobTitle.lastIndexOf('.') + 1).trim()
    } else {
        expectedPosition = fullJobTitle // fallback nếu không có dấu chấm
    }

    println "🔍 Extracted position: $expectedPosition"

    randomOption.click()
} else {
    println "⚠️ No job options found."
    assert false
}

WebUI.click(findTestObject('Page_Candidates by Status  E STAFF/button_Filter'))

// Đợi table load lại sau filter
WebUI.delay(2)

// Lấy danh sách tất cả dòng trong bảng
List<WebElement> rows = driver.findElements(By.xpath('//*[@id="example"]/tbody/tr'))

// Lặp và kiểm tra cột thứ 3
for (int i = 0; i < rows.size(); i++) {
    WebElement thirdColumn = rows[i].findElement(By.xpath('td[3]'))
    String cellText = thirdColumn.getText().trim()

    println("🔎 Row ${i + 1} - Column 3: $cellText")
    assert cellText == expectedPosition : "❌ Expected: $expectedPosition | Found: $cellText"
}

println "✅ All rows match expected job position: $expectedPosition"
