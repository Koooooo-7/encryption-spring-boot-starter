package com.koy.springboot.encryption.autoconfigure;

import com.koy.springboot.encryption.executor.AesExecutor;
import com.koy.springboot.encryption.executor.CryptoExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @author Koy  https://github.com/Koooooo-7
 */
@EnableConfigurationProperties(CryptoProperties.class)
@Configuration
public class CryptoConfiguration {

    @Autowired
    CryptoProperties cryptoProperties;

    @Bean
    @ConditionalOnProperty(prefix="encryption",name = "type",havingValue = "aes128")
    public CryptoExecutor aesFactory(){
        String secretKey = cryptoProperties.getSecretKey();
        Assert.hasText(secretKey, "secretKey must not be empty");
        Assert.isTrue(secretKey.length() == 16,"secretKey has bad length");
        return new AesExecutor(cryptoProperties);
    }
}
