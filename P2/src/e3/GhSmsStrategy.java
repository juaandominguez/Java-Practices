package e3;

import java.util.Random;

public class GhSmsStrategy implements MfaStrategy{
    @Override
    public String generateCode() {
        Random random = new Random();
        return String.format("%06d",(random.nextInt(999999))); // Return a random 6 digit number
    }
}
