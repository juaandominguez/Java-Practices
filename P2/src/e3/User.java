package e3;

import java.util.HashMap;
import java.util.Map;

public class User {
    public void setMfaStrategy(String uid,MfaStrategy mfaStrategy ){preferredMfa.put(uid,mfaStrategy);}
    Map<String, String> users = new HashMap<>(); //user-password map
    Map<String, MfaStrategy> preferredMfa = new HashMap<>(); //user-MfaStrategy map
    Map<String, LoginStrategy> preferredLogin = new HashMap<>(); //user-LoginStrategy map
    public void addUser(String uid, String passwd,LoginStrategy loginStrategy){
        users.put(uid, passwd); preferredLogin.put(uid,loginStrategy); //add a user to the user-password map
    }
    public Map<String, String> getMap(){
        return users;
    }
    public MfaStrategy getMfaStrategy(String uid){return preferredMfa.get(uid);}
    public LoginStrategy getloginStrategy(String uid){
        return preferredLogin.get(uid);
    }

}
