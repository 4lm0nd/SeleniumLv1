package railway;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {

    //Locator
    private static final By btnCancel = By.xpath("//table[@class='MyTable']//tr[last()]/td[last()]/input");
    private static final By myTable = By.className("MyTable");

    //Element
    public WebElement getBtnCancel() {
        return Constant.DRIVER.findElement(btnCancel);
    }

    public WebElement getMyTable() {
        return Constant.DRIVER.findElement(myTable);
    }

    //Method

    public void cancelTicket() {
        getBtnCancel().click();
        Alert alert = Constant.DRIVER.switchTo().alert();
        alert.accept();
    }

}
