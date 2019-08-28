package com.koy.springboot.encryption.core;

import com.koy.springboot.encryption.exception.ExecutorDecryptedFailedException;
import com.koy.springboot.encryption.executor.CryptoExecutor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author Koy  https://github.com/Koooooo-7
 */
@Aspect
@Component
public class DecryptService {

    @Autowired
    private CryptoExecutor cryptoExecutor;

    @Pointcut("@annotation(com.koy.springboot.encryption.annotation.Decrypt)")
    public void decrypt() {}

    @Around("decrypt()")
    public void decryptCode(ProceedingJoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        // get the first (should be only one param indeed ) must be string
        Assert.isInstanceOf(String.class,args[0],"need decrypt param should be String");

        String s = (String)args[0];
        // execute the decrypt
        String decrypt = cryptoExecutor.decrypt(s);
        if (StringUtils.isEmpty(decrypt)){
            throw new ExecutorDecryptedFailedException("executor decrypted failed, result is empty");
        }
        try {
            // change the code to decrypt result
            args[0] = decrypt;
            joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
