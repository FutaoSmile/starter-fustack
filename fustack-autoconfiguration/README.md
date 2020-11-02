### # 自动配置模块
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
        