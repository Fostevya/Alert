package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage {

    private WebElement alertElement;
    private WebDriverWait wait;

    public ElementsPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[a[contains(@href,'menu.php')][h2]]"))));
        alertElement = driver.findElement(By.xpath("//li[a[contains(@href,'alert.php')][h2]]"));
    }

    public void alertElementClick() {
        alertElement.click();
    }

}