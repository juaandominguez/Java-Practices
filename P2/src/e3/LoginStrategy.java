package e3;

import java.util.Map;

public abstract class LoginStrategy {
    Map<String, String> m;
    public void setMap(Map<String, String> m){
        this.m= m;
    }
    public Map<String, String> getMap(){
        return m;
    } //Get the user-password map

    abstract boolean validateId(String id);
    public boolean authenticatePassword(String id, String password) {
       return m.get(id).equals(password);

    }

}
