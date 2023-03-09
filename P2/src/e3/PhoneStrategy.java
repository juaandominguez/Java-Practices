package e3;
import java.util.regex.Pattern;

public class PhoneStrategy extends LoginStrategy {
    @Override
    public boolean validateId(String id) {
        if(!getMap().containsKey(id)) return false;//If the id is not in the map, id is false
        if(id==null) return false;//If id is null, is not valid
        String phoneRegex="^\\+(?:[0-9] ?){6,14}[0-9]$";//"+" is international prefix symbol, followed by the country code and phone number
        Pattern p = Pattern.compile(phoneRegex);//Compile the regular expression into a pattern
        return p.matcher(id).matches();// Matches the input with the pattern
    }
}
