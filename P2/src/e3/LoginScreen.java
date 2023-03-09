package e3;
import java.util.stream.Collectors;

public class LoginScreen {
    User c = new User();

    public void createUser(String uid, String passwd,MfaStrategy mfaStrategy,LoginStrategy loginStrategy){
        c.addUser(uid,passwd,loginStrategy);c.setMfaStrategy(uid,mfaStrategy); //Add a user to the user list
    }
    public Boolean enterUserId(String uid){
        LoginStrategy loginStrategy= c.getloginStrategy(uid);
        try{loginStrategy.setMap(c.getMap());} //If the user does not exist return false instead of an exception
        catch (Exception ignored){
            return false;
        }
        return loginStrategy.validateId(uid); //Return true if the username is valid and is in the map
    }

    public String enterPassword(String uid,String passwd) {
        LoginStrategy loginStrategy= c.getloginStrategy(uid);
        try{loginStrategy.setMap(c.getMap());} //If the user does not exist then the password is not valid
        catch (Exception ignored){
            return "Password not valid";
        }
        if (loginStrategy.validateId(uid)) {
            if (loginStrategy.authenticatePassword(uid, passwd)) {
                return c.getMfaStrategy(uid).generateCode(); //If the user exists and the password is valid, return the preferred MFA code of the user
            }
        }
        return "Password not valid"; //Otherwise the password is not valid
    }

}
