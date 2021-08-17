## TinyDIFramework 简介

TinyDI 是一个基于DI模式实现的一个轻量级DI框架，支持通过构造器注入依赖。

## DI framework Sbe

依赖注入是一种我们可以用来实现控制反转的一种模式，通过将类生命周期的管理交给容器进行管理得以实现。
通常来讲，当需要申明一个类的依赖时会有如下代码
```java
public class Car {
    private Wheel wheel;
 
    public Car() {
        wheel = new wheelImpl1();    
    }
}

```

如果使用依赖注入的实现方式，则会有如下代码：
```java
public class Car {
    private Wheel wheel;
 
    public Car(Wheel wheel) {
        this.wheel = wheel;    
    }
}

```
Car依赖与Wheel，当Car初始化时，容器（Container）会在上下文（Context）环境中找到Wheel类，并将其注入到（Inject）到Car类的构造函数中。


## 容器的使用

只有当一个类被注册到容器中时，容器才能在需要注入的时候找到该类

1. 将一个类注册到容器当中。注册一个类到容器当中可以使用register()命令
```java
container.register(Wheel.class)
```
2. 从容器中获取一个类的实例。已经被注册到容器中的类，容器会维护其实例的生命周期，当需要获取该实例的时候，
   可以通过getInstance()方法获取到相应的实例
```java
container.register(Wheel.class)
container.getInstance(Wheel.class) 
```
3. 如果想要获取一个未被注册到容器中的类的实例时，此时显然会抛出一个错误
```java
container.getInstance(Wheel.class) //throw CreateInstanceFailedException
```

## 如何注入
1. 使用@Inject注解进行标注

   我们推荐使用构造器注入的方式进行依赖注入。

   假设当前容器中已经注册了类Wheel。

   当我们需要将Car类注册到容器当中时，
   类Car依赖于类Wheel，其构造函数可以写成如下所示
```java
    public class Car {
        private Wheel wheel;
 
        @Inject
        public Car(Wheel wheel) {
            this.wheel = wheel;    
        }
    }
```
   使用@Inject可以让容器知道这里需要注入依赖。

   当该类被容器实例化时，容器会调用其构造函数，发现构造函数被@Inject注解，就会在容器中寻找其所需依赖，并调用其构造方法，从而正确的注入依赖。
