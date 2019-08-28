package com.koy.springboot.encryption.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Koy  https://github.com/Koooooo-7
 */
@ConfigurationProperties(prefix="encryption")
public class CryptoProperties {

    // which encrypt or decrypt type , eg: aes
    private String type;

    // the secretKey
    private String secretKey;

    // the key need to encrypt with secretKey
//    private String plainKey;

    // the  encryptedKey need decrypt by the secretKey
    private String encryptedKey;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }
}
