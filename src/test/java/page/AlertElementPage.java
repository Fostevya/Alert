package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertElementPage {


    private WebElement inputAllertTab;
    private WebElement demonstrateAlertButton;
    private WebElement resultString;
    private WebDriverWait wait;

    public AlertElementPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//a[contains(.,'Input Alert')]"))));
        inputAllertTab = driver.findElement(By.xpath("//a[contains(.,'Input Alert')]"));
        driver.switchTo().frame(1);
        demonstrateAlertButton = driver.findElement(By.xpath("//button[contains(.,'demonstrate')]"));
        resultString = driver.findElement(By.id("demo"));
        driver.switchTo().defaultContent();
    }

    public void inputAlertTabClick() {
        inputAllertTab.click();
    }

    public void demonstrateAlertButtonClick(WebDriver driver) {
        driver.switchTo().frame(1);
        demonstrateAlertButton.click();
    }

    public void writeTextInAlertAndThenClose(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        driver.switchTo().parentFrame();
    }

    public String getTextFromResultString(WebDriver driver) {
        driver.switchTo().frame(1);
        String result = resultString.getText();
        driver.switchTo().parentFrame();
        return result;
    }
}