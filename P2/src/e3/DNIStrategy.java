package e3;
import java.util.regex.Pattern;

public class DNIStrategy extends LoginStrategy{
    @Override
    public boolean validateId(String id) {
        if(!getMap().containsKey(id)) return false;//If the id is not in the map, id is false
        if(id==null) return false;//If id is null, is not valid
        String DNIRegex="[0-9]{8}[A-Z]";//The expression must be 8 numbers and 1 character
        Pattern p=Pattern.compile(DNIRegex);//Compile the regular expression into a pattern
        String controlDigit="TRWAGMYFPDXBNJZSQVHLCKE";//Control digits related to the number mod 23
        String prohibited1="00000000T";String prohibited2="00000001R";//DNI prohibited by the Ministry of the Interior
        String prohibited3="99999999R";
        return (!id.equals(prohibited1) && !id.equals(prohibited2)&& !id.equals(prohibited3))
        &&(p.matcher(id).matches()) // Check if the DNI validates the regex and it is not one of the forbidden DNIs
        &&(id.charAt(8)==controlDigit.charAt(Integer.parseInt(id.substring(0,8))%23));//Checks if the number sequence is the corresponding letter (the number must fix the associatted char mod 23).
    }
}
