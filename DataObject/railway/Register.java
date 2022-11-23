package railway;

public class Register {

    private String email;
    private String password;
    private String confirmPassword;
    private String PID;

    public Register(String email, String password, String confirmPass, String pid) {
        this.email = getEmail(email);
        this.password = getPassword(password);
        this.confirmPassword = getConfirmPassword(confirmPass);
        this.PID = getPID(pid);
    }

    public String getEmail(String mail) {
        email = mail;
        return email;
    }

    public String getPassword(String pass) {
        password = pass;
        return password;
    }

    public String getConfirmPassword (String confirmPass){
        confirmPassword = confirmPass;
        return confirmPassword;
    }

    public String getPID (String pid){
        PID = pid;
        return PID;
    }
}
