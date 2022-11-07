package Railway;

import Railway.GeneralPage;
import Railway.Homepage;

public class Test {

 static GeneralPage common;
 static LoginPage login;

    public static void main(String[] args)
    {

     common = new GeneralPage();
     common.OpenRailway();
     common.GotoTab("Login");
     login = new LoginPage();
     login.Login(Constant.USER_NAME,Constant.PASSWORD);

    }

}
