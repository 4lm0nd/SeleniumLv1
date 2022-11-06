package Railway;

import Railway.GeneralPage;
import Railway.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    GeneralPage common;

    //Locator

    private By _txtemail = By.id("username");
    private By _txtpass = By.id("password");
    private By _btnlogin = By.xpath("//input[@title='Login']");

    //Element
    public WebElement getemailtxt(){return Constant.driver.findElement(_txtemail);}
    public WebElement getpasswordtxt() {return Constant.driver.findElement(_txtpass);}
    public WebElement getloginbtn() {return Constant.driver.findElement(_btnlogin);}

    //Method
    public void Login(String email, String pass){

       getemailtxt().sendKeys(email);
       getpasswordtxt().sendKeys(pass);
       getloginbtn().click();

    }


}
