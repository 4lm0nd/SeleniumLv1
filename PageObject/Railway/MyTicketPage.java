package Railway;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //Locator
    private By pageTitle = By.xpath("//div[@id='content']/h1");


    //Element
    public WebElement getPageTitle() {
        return Constant.DRIVER.findElement(pageTitle);
    }

    //Method
    public void cancelTicket(){

        WebElement btnCancel = Constant.DRIVER.findElement(By.xpath("//table[@class='MyTable']//tr[last()]/td[count(//tr[@class='TableSmallHeader']/th[contains(text(),'Operation')]/preceding-sibling::th)+1]/input"));
        btnCancel.click();
        Alert alert = Constant.DRIVER.switchTo().alert();
        alert.accept();
    }
}
