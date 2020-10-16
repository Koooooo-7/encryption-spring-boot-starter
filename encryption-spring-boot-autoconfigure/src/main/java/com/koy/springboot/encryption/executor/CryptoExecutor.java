package com.koy.springboot.encryption.executor;

/**
 * @author Koy  https://github.com/Koooooo-7
 */
public interface CryptoExecutor {
    /**
     * the string need to encrypt
     *
     * @param s
     * @return
     */
    String encrypt(String s);

    /**
     * the string need to decrypt
     *
     * @param s
     */
    String decrypt(String s);
}
