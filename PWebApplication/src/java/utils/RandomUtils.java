/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Math.random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.CustomerService;

/**
 *
 * @author Fred
 */
public class RandomUtils {

    private static final long ONE_YEAR_IN_MILLISECONDS = 31557600000L;

    public static String randomMD5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(String.valueOf(randomLongInt()).getBytes());
            byte[] mdbytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RandomUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return Une date comprise entre maintenant et +/- un an
     */
    public static long randomDateInMilliseconds() {
        long now = System.currentTimeMillis();
        return (long) (now + ONE_YEAR_IN_MILLISECONDS * (2 * random() - 1));
    }

    public static long randomLongInt() {
        return (long) (random() * Long.MAX_VALUE);
    }

    public static int randomInt() {
        return (int) (random() * 9999999);
    }
}
