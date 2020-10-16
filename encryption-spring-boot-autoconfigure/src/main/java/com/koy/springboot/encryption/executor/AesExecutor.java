package com.koy.springboot.encryption.executor;

import com.koy.springboot.encryption.autoconfigure.CryptoProperties;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author Koy  https://github.com/Koooooo-7
 * <p>
 * the AesExecutor can use the AES algorithm to execute encryption or decryption
 */
public class AesExecutor implements CryptoExecutor {

    private byte[] secretKey;

    private String plainKey;

    private String encryptedKey;

    private CryptoProperties cryptoProperties;


    public AesExecutor(CryptoProperties cryptoProperties) {
        this.cryptoProperties = cryptoProperties;
        this.secretKey = this.cryptoProperties.getSecretKey().getBytes();

    }

    @Override
    public String encrypt(String s) {
        Key key = new SecretKeySpec(this.secretKey, "AES");
        Cipher cipher = null;
        try {
            // select encrypt type
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(s.getBytes());
            return Hex.encodeHexString(result);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decrypt(String s) {
        Cipher cipher;
        Key key = new SecretKeySpec(this.secretKey, "AES");
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] s2bytes = Hex.decodeHex(s);
            byte[] result = cipher.doFinal(s2bytes);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return null;
    }
}
