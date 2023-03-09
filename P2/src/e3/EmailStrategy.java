package e3;
import java.util.regex.Pattern;

public class EmailStrategy extends LoginStrategy{

    @Override
    public boolean validateId(String id) {
        if(!getMap().containsKey(id)) return false;//If the id is not in the map, id is false
        if(id==null) return false;//If id is null, is not valid
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";//Restrictions to the email address

            Pattern p = Pattern.compile(emailRegex);//Compile the regular expression into a pattern
            return p.matcher(id).matches(); // Matches the input with the pattern
        }

}
