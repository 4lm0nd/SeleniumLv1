package railway;


public class Login {

    private String email;
    private String pass;

    public Login(String username, String password) {
        this.email = getEmail(username);
        this.pass = getPass(password);
    }

    public String getEmail(String username)
    {
       email = username;
        return email;
    }

    public String getPass (String password)
    {
        pass = password;
        return pass;
    }

}

