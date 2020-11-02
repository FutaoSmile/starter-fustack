### # 配置文件加密 jasypt
* https://github.com/ulisesbocchio/jasypt-spring-boot
* 依赖
```xml
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
```
* 设置密码: `jasypt.encryptor.password=xxx`
    * 不可以被泄露哟，可以在IDEA的Program arguments设置。
* 加密命令 *`mvn jasypt:encrypt-value -Djasypt.encryptor.password="the password" -Djasypt.plugin.value="theValueYouWantToEncrypt"`*
* 加密解密
```java
@Autowired
    private StringEncryptor encryptor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(encryptor.encrypt("123456"));
        System.out.println(encryptor.decrypt("12mXd8r6ni5ZGrqOOm7xNxkyJJImJzysOjY6JqZo2Ouj2Hf/Azlpzdf1BW+Rczl0t63UCeoS1yVZe3v3DLiQIA=="));
    }
```

### # 自动配置
1. 编码流程
    1. 在编写好其他模块之后，将其他模块的依赖引入
        1. 设置该模块的`<optional>true</optional>`
    1. 创建自动配置类
        1. 包名 = `模块名`
        2. 类名 = `模块名AutoConfiguration`
    2. 编写`XxxAutoConfiguration`类
        1. 启用条件
        2. 导入扫描类
    3. 在[resources/META-INF/spring.factories](resources/META-INF/spring.factories)文件的`org.springframework.boot.autoconfigure.EnableAutoConfiguration`属性下加入新写的自动配置类，并用逗号分隔
    4. 打包，发布
        

### # 版本发布
* 地址: jitpack.io
* github上设置release
