package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {
    //Variable
    String tabMenu = "//span[text()='%s']/ancestor::a";
    String cellTable = "//table[@class='%s']//tr[%d]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'%s')]/preceding-sibling::th)+1]";
    private static By pageTitle = By.xpath("//div[@id='content']/h1");

    //Element
    WebElement getTabMenu(String tabName) {
        return Constant.DRIVER.findElement(By.xpath(String.format(tabMenu, tabName)));
    }
    WebElement getPageTitle() {
        return Constant.DRIVER.findElement(pageTitle);
    }
    WebElement getCellTable(String table, String column, int row) {
        return Constant.DRIVER.findElement(By.xpath(String.format(cellTable, table, row, column)));
    }

    //Method
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void goToTab(String tab) {
                getTabMenu(tab).click();
    }

    public void selectItemFromList(By list, String option) {
        Select mySelect = new Select(Constant.DRIVER.findElement(list));
        mySelect.selectByVisibleText(option);
    }

    public void waitForControl(By element, int timeoutInSeconds) {
        WebElement myElement = new WebDriverWait(Constant.DRIVER, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
        boolean check = false;
        for (int i = 0; i < timeoutInSeconds; i++) {
            try {
                if (myElement.isDisplayed() != check) {
                    Thread.sleep(timeoutInSeconds * 1000);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getTitlePage() {
        String titlePage = getPageTitle().getText().toString();
        return titlePage;
    }

    public void openSite(String site) {
        BrowserManager.openBrowser(Constant.BROWSER, Constant.WEB_DRIVER, Constant.DRIVER_PATH);
        Constant.DRIVER.get(site);
        Constant.DRIVER.navigate();
    }

    public String getTableCellValue(String table, String column, int row) {
        String cellValue = getCellTable(table, column, row).getText().toString();
        return cellValue;
    }

    public int getTableRow(String table, String departStation, String arriveStation, int rows) {
        for (int i = 1; i <= rows; i++) {
            if (getTableCellValue(table, "Depart Station", i).equals(departStation))
                if (getTableCellValue(table, "Arrive Station", i).equals(arriveStation)) {
                    return i;
                }
        }
        return 0;
    }
}



