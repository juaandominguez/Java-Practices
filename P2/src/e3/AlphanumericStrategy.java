package e3;

import java.util.Random;
import java.util.UUID;

public class AlphanumericStrategy implements MfaStrategy{
    @Override
    public String generateCode() {
        Random random = new Random();
        return (UUID.randomUUID().toString()).replace("-","").substring(0,random.nextInt(10)+12); //Create a pseudo-random password in hexadecimal and of 12-21 digits

    }
}
