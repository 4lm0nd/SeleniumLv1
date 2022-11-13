package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.Console;
import java.time.Duration;

public class GeneralPage {

    //Method
    public void scrollByPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void goToTab(String tab) {
        Constant.DRIVER.findElement(By.xpath("//span[text()='" + tab + "']/ancestor::a")).click();
    }

    public void selectItemFromList(By list, String option) {
        Select mySelect = new Select(Constant.DRIVER.findElement(list));
        mySelect.selectByVisibleText(option);
    }
    public String getTableCellValue(String table, String column, int row) {
        String cellValue = Constant.DRIVER.findElement(By.xpath("//table[@class='" + table + "']//tr[" + row + "]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'" + column + "')]/preceding-sibling::th)+1]")).getText().toString();
        return cellValue;
    }

    public void waitForControl(By element, int timeoutInSeconds)
    {
        WebElement myElement = new WebDriverWait(Constant.DRIVER, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));

        boolean check = false;
        for (int i = 0; i < timeoutInSeconds; i++)
        {
            try
            {
                if (myElement.isDisplayed() != check)
                {
                   Thread.sleep(timeoutInSeconds*1000);
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}



