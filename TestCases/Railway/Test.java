package Railway;

public class Test {

 static GeneralPage generalPage;
 static LoginPage loginPage;

    public static void main(String[] args)
    {

     generalPage = new GeneralPage();
     generalPage.OpenRailway();
     generalPage.GotoTab("Login");
     generalPage.scrollByPage();
     loginPage = new LoginPage();
     loginPage.Login(Constant.USER_NAME,Constant.PASSWORD);

    }

}
