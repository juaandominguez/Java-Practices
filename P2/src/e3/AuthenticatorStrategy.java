package e3;

import java.util.Random;

public class AuthenticatorStrategy implements MfaStrategy{
    @Override
    public String generateCode() {
        Random random = new Random();
        int digits = random.nextInt() % 3 + 6;
        return switch (digits) {
            case 6 -> String.format("%06d", (random.nextInt(999999)));
            case 7 -> String.format("%07d", (random.nextInt(9999999)));
            default -> String.format("%08d", (random.nextInt(99999999))); //Create a random number between 6 and 8 digits
        };
    }
}
