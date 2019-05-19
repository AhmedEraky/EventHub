/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eventhub.dal.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encryption utilities to be used across the application
 *
 * @author Amr Elkady <amrelkady93@gmail.com>
 * @author Ibrahim Yousre (ib.yousre@gmail.com)
 */
public class EncryptionUtils {

    private static final String KEY = "Bar12345Bar12345";

    /**
     * To be used for hashing password this method use one way hashing algorithm PBKDF2
     * TODO: change salt, each user should have his own salt for example uuid
     *
     * @param password
     * @return hashed password
     * @author Ibrahim Yousre (ib.yousre@gmail.com)
     */
    public static String hash(String password) {
        try {
            byte[] salt = KEY.getBytes();
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException("Hashing failed", ex);
        }
    }

    /**
     * this method convert plain text to encrypt by AES algorithm
     *
     * @param plainText
     * @return encrypted text with encoding to base64
     * @author Amr Elkady <amrelkady93@gmail.com>
     * {@link https://stackoverflow.com/a/30591269/5331778}
     */
    public static String encrypt(String plainText) {
        try {
            Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new RuntimeException("Encryption failed", ex);
        }
    }

    /**
     * this method convert encrypt to plain text by AES algorithm
     *
     * @param encryptionText
     * @return original text
     * @author Amr Elkady <amrelkady93@gmail.com>
     * {@link https://stackoverflow.com/a/30591269/5331778}
     */
    public static String decrypt(String encryptionText) {
        try {
            Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] encoded = Base64.getDecoder().decode(encryptionText.getBytes());
            return new String(cipher.doFinal(encoded));
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            throw new RuntimeException("Dencryption failed", ex);
        }
    }

}
