package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenTest {
    static LoginScreen l = new LoginScreen();
    static MfaStrategy mfaStrategy1 = new AlphanumericStrategy();
    static MfaStrategy mfaStrategy2 = new AuthenticatorStrategy();
    static MfaStrategy mfaStrategy3 = new GhMobileStrategy();
    static MfaStrategy mfaStrategy4 = new GhSmsStrategy();
    static LoginStrategy strategy1 = new EmailStrategy();
    static LoginStrategy strategy2 = new PhoneStrategy();
    static LoginStrategy strategy3 = new DNIStrategy();

    @BeforeAll
    static void setStrategies(){
        l.createUser("thcej@udc.es","soyth",mfaStrategy1,strategy1);
        l.createUser("elboo@yahoo.es","recu889",mfaStrategy2,strategy1);
        l.createUser("segmentationfault@h.com","messi",mfaStrategy3,strategy1);
        l.createUser("howso@gmail.es","HowComes",mfaStrategy4,strategy1);
        l.createUser("mentalidaddetiburon@mojado.zb","DopazoConductordeCamiones",mfaStrategy1,strategy1);
        l.createUser("73065460A","Nicaragua",mfaStrategy2,strategy3);
        l.createUser("00000000T","HOLA111",mfaStrategy3,strategy3);
        l.createUser("+34691185682","Xd123",mfaStrategy4,strategy2);
        l.createUser("+569678271","lllll",mfaStrategy1,strategy2);
        l.createUser("-45782461","Xd123",mfaStrategy2,strategy2);
        l.createUser(null,"duiabduiawbd",mfaStrategy1,strategy1);
    }


    @Test
    void User() {
        assertEquals("{null=duiabduiawbd, +34691185682=Xd123, 73065460A=Nicaragua, elboo@yahoo.es=recu889, segmentationfault@h.com=messi, +569678271=lllll, -45782461=Xd123, thcej@udc.es=soyth, howso@gmail.es=HowComes, mentalidaddetiburon@mojado.zb=DopazoConductordeCamiones, 00000000T=HOLA111}",l.c.getMap().keySet().stream().map(key->key + "=" + l.c.getMap().get(key)).collect(Collectors.joining(", ","{","}")));
    }


    @Test
    void validateUserIdEMail() {
        assertFalse(l.enterUserId(null));
        assertTrue(l.enterUserId("thcej@udc.es"));
        assertFalse(l.enterUserId("thcejotaud.es"));
        assertFalse(l.enterUserId("lol@fic.es"));
    }
    @Test
    void validateUserIdDNI() {
        assertFalse(l.enterUserId("64891610p"));
        assertTrue(l.enterUserId("73065460A"));
        assertFalse(l.enterUserId("00000000T"));
        assertFalse(l.enterUserId("415sdsasQ"));


    }

    @Test
    void validateUserIdPhone() {
        assertTrue(l.enterUserId("+34691185682"));
        assertTrue(l.enterUserId("+569678271"));
        assertFalse(l.enterUserId("-45782461"));
    }



    @Test
    void authenticatePassword() {
        System.out.println(l.enterPassword("thcej@udc.es","soyth"));
        assertEquals(l.enterPassword("thcej@udc.es","soh"),"Password not valid");
        System.out.println(l.enterPassword("howso@gmail.es","HowComes"));
        System.out.println(l.enterPassword("segmentationfault@h.com","messi"));
        assertEquals(l.enterPassword("segmentationfault@h.com","mesi"),"Password not valid");
        System.out.println(l.enterPassword("73065460A","Nicaragua"));
        assertEquals(l.enterPassword("73065460A","Nica"),"Password not valid");
        assertEquals(l.enterPassword(null,"Nica"),"Password not valid");
        System.out.println(l.enterPassword("thcej@udc.es","soyth"));
        System.out.println(l.enterPassword("00000000T","HOLA111"));
        System.out.println(l.enterPassword("73065460A","Nicaragua"));

    }
}