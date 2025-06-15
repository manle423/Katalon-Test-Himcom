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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import java.util.Random as Random
import java.time.Duration as Duration
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

CustomKeywords.'custom.keywords.NavigationActions.navigateToEmployeePermanentEmployees'()

WebDriver driver = DriverFactory.getWebDriver()

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10))

// Lấy danh sách tất cả link “View Employee”
List<WebElement> companyLinks = driver.findElements(By.xpath('//table//tbody//tr/td[3]/a'))

for (int i = 0; i < companyLinks.size(); i++) {
    // Re-find element sau mỗi lần navigate
    companyLinks = driver.findElements(By.xpath('//table//tbody//tr/td[3]/a'))
    (companyLinks[i]).click()
    WebUI.delay(2)
    List<WebElement> employeeRows = driver.findElements(By.xpath('//table//tbody//tr'))
    if (employeeRows.size() == 0) {
        // Không có nhân viên → quay lại
        WebUI.click(findTestObject('Object Repository/Page_Permanent Employees - List  E STAFF/button_Back'))
        WebUI.delay(1)
        continue
    }
    String firstEmployeeName = (employeeRows[0]).findElement(By.xpath('td[1]')).getText()

    WebElement searchBox = driver.findElement(By.cssSelector('input[type=\'search\']'))
    searchBox.clear()
    searchBox.sendKeys(firstEmployeeName)
    WebElement searchBtn = driver.findElement(By.xpath('//button[@type=\'submit\']'))
    searchBtn.click()
    WebUI.delay(1)
    List<WebElement> searchResults = driver.findElements(By.xpath('//table//tbody//tr'))
    assert searchResults.size() > 0
    WebUI.comment("Tìm thấy nhân viên [$firstEmployeeName] thành công.")

    break
}

WebElement dotsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath('//table//tr[1]//button[.//i[contains(@class, \'bx-dots-vertical-rounded\')]]')))

dotsBtn.click()

WebElement viewBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath('//a[contains(@href, \'/admin/employee/permanent/view/\')]')))

viewBtn.click()

WebUI.delay(2)

WebElement originalPhoneEl = driver.findElement(By.xpath('//label[text()=\'House Phone Number:\']/following-sibling::span'))

String originalPhone = originalPhoneEl.getText().trim()

WebUI.comment('Original House Phone Number: ' + originalPhone)

WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath('//button[contains(., \'Edit\')]')))

editBtn.click()

WebUI.delay(1)
String newPhone = '090' + (100000000 + new Random().nextInt(900000000)).toString().substring(2)
WebElement inputPhone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath('//label[contains(text(), \'House Phone Number:\')]/following-sibling::input')))
inputPhone.clear()
inputPhone.sendKeys(newPhone)
WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath('//button[contains(@class, \'btn-success\') and contains(text(), \'Submit\')]')))

WebElement updatedPhoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath('//label[contains(text(), \'House Phone Number:\')]/following-sibling::input')))

WebUI.verifyTextPresent('View Employee', false)

WebUI.closeBrowser()

