# Mini-Spring Framework

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Coverage](https://img.shields.io/badge/coverage-80%25-green.svg)

## 项目简介
Tiny-Spring 是一个简化版的 Spring 框架，旨在帮助开发者深入理解 Spring 的核心原理和实现机制。本项目采用问题驱动的方式，通过实现核心功能模块，让学习者能够深入理解 Spring 的设计思想和实现原理。

## 设计理念
本框架采用分层架构设计，遵循以下核心原则：
1. **控制反转**：通过三级缓存解决循环依赖
2. **扩展性优先**：基于SPI机制实现组件扩展
3. **性能优化**：使用CGLIB动态代理池技术
4. **模块解耦**：核心模块间通过抽象接口通信

---

## 核心模块解析

### IoC容器架构
```mermaid
classDiagram
    class BeanFactory{
        +getBean()
        +containsBean()
    }
    class ApplicationContext{
        +refresh()
        +getEnvironment()
    }
    class BeanDefinition{
        -beanClass
        -propertyValues
    }
    BeanFactory <|-- ApplicationContext
    BeanFactory *-- BeanDefinition
```

### AOP实现机制

1. 代理工厂采用策略模式（JDK/CGLIB动态代理）
2. 切面表达式解析使用ANTLR4
3. 通知链执行通过责任链模式实现

### 关键技术决策
<div style="text-align: center;">
| 技术点           | 方案选择             | 决策依据                       |
|:----------------:|:-------------------:|:-----------------------------:|
| 依赖注入         | 构造器注入优先       | 保证对象不可变状态            |
| Bean作用域管理   | ThreadLocal存储      | 支持Request/Session作用域     |
| 配置加载         | 多格式兼容设计       | 支持XML/Annotation/YAML       |
| 事务管理         | 连接点拦截器链       | 支持嵌套事务回滚              |
</div>

### 性能优化记录
Bean实例化优化
```java
// 基于原型模式的Bean缓存池
public class BeanPool {
    private static final Map<String, Queue<Object>> pool = new ConcurrentHashMap<>();
    
    public static Object borrowBean(String beanName) {
        return pool.getOrDefault(beanName, new ConcurrentLinkedQueue<>()).poll();
    }
    
    public static void returnBean(String beanName, Object bean) {
        pool.computeIfAbsent(beanName, k -> new ConcurrentLinkedQueue<>()).offer(bean);
    }
}
```

## 项目结构
````
mini-spring
```
src/main/java/com/minispring/
├── beans
│   ├── factory
│   │   ├── config
│   │   │   ├── Scope相关接口和实现
│   │   │   └── ...
│   │   ├── support
│   │   └── xml
│   ├── BeansException.java
│   ├── PropertyValue.java
│   ├── PropertyValues.java
│   └── ...
├── context
│   ├── event
│   ├── support
│   ├── ApplicationContext.java
│   └── ...
├── core
│   ├── io
│   ├── convert
│   │   ├── converter
│   │   ├── support
│   │   └── ...
│   └── ...
├── aop
│   ├── framework
│   ├── aspectj
│   ├── Advisor.java
│   ├── PointcutAdvisor.java
│   └── ...
├── web
│   ├── context
│   │   ├── request
│   │   │   ├── RequestScope.java
│   │   │   ├── SessionScope.java
│   │   │   └── ...
│   │   └── ...
│   └── ...
└── util
    └── ...
```
````

## 环境要求
- JDK 17+
- Maven 3.8.1+
- IDE（推荐IntelliJ IDEA）
- Git

## 快速开始

### 1. 获取代码
```bash
# 克隆项目
git clone https://github.com/youngyangyang04/mini-spring.git

# 进入项目目录
cd mini-spring
```

### 2. 编译运行
```bash
# 编译项目
mvn clean install

# 运行测试
mvn test
```

### 3.运行测试用例
项目包含完整的测试用例，覆盖了框架的主要功能：
- IoC容器测试
- AOP功能测试
- 事务管理测试

可以通过IDE或命令行运行这些测试：
```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=DefaultListableBeanFactoryTest

# 运行特定测试方法
mvn test -Dtest=DefaultListableBeanFactoryTest#testGetBean
```

### 5. 开发建议
- 建议使用IDE（如IntelliJ IDEA）导入项目
- 确保已安装JDK 17及以上版本
- 推荐使用Maven 3.8.1及以上版本
- 运行测试前先执行`mvn clean install`


## 如何贡献
1. Fork 本仓库
2. 创建新的分支 `git checkout -b feature/your-feature`
3. 提交你的修改 `git commit -m 'Add some feature'`
4. 推送到分支 `git push origin feature/your-feature`
5. 创建 Pull Request

## 问题反馈
- 在GitHub Issues中提问
- 通过Pull Request贡献内容
- 查看文档中的常见问题解答

## 开源协议
本项目采用 MIT 协议开源，详见 [LICENSE](LICENSE) 文件。 
