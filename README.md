# encryption-spring-boot-starter
> A Springboot starter for secret.



## Description

`encryption-spring-boot-starter` is a `Springboot` starter .

Support `JDK` version 1.8 or 1.8+.

I  wanna  collect and implement  some different to  be  a  starter.

And just use `@Encrypt` / `@Decrypt` annotation on method to modify the input param. 



## Crypto  List

|      | Type   | Status             |
| ---- | ------ | ------------------ |
| 1    | aes128 | :heavy_check_mark: |
| 2    |        |                    |
| 3    | ...    | ...                |

### Crypto details

- `aes128` 
  -  `AES`
  - `model`:  `ECB（Electronic Code Book）`
  - `cipher length`: `128`
- `Complement mode `:  `PKCS5Padding`
  
   Also you can test the result on website tool :wrench:. (such as [this one](http://www.seacha.com/tools/aes.html)):

## How to use

- `Maven project`

​       Import `pom.xml`

```xml
 <dependency>
       <groupId>com.koy.springboot</groupId>
       <artifactId>encryption-spring-boot-starter</artifactId>
       <version>1.0.0</version>
  </dependency>
```

- `Config application.yml`

```yml
encryption:
  type: aes128          
  secret-key: "abcdefghabcdefg2"
  encrypted-key: "9b1d2630003ee9a8c674228e08fab4ce"
```

`type` : the `encryption`/`decryption` type you chose to use ( eg: `aes128`).

`secret-key`: the secret-key to use.

`encrypted-key`: the code which was encrypted.

- `Config  Springboot @ComponentScan`

  ```java
  @SpringBootApplication
  // ComponentScan the com.koy.springboot and your own project
  @ComponentScan({"com.koy.springboot","com.mt.encrypt" })
  public class EncryptApplication {
      public static void main(String[] args) {
          SpringApplication.run(EncryptApplication.class, args);
      }
  
  }
  ```

  

- use the annotation  `@Encrypt` / `@Decrypt`

```java
    @Decrypt
    public void login(String encryptedString) {
        ...
    }
```

```java
    @Encrypt
    public void register(String plainString){
       ...
    }
```



## Contribute

If  you wanna do it together, welcome to PR.:rocket:

## License

 MIT  .