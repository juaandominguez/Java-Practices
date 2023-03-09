package e3;
import java.util.Random;

public class GhMobileStrategy implements MfaStrategy{
    @Override
    public String generateCode() {
        Random random = new Random();
        return String.format("%02d",(random.nextInt(99))); //Return a random 2 digit number
    }
}
