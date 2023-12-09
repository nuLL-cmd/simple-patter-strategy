# simple-patter-strategy

The Strategy design pattern is a behavioral pattern that can encapsulate algorithms in a interchangeable manner, allowing the programmer to choose which algorithm to use at runtime without affecting the code structure.

The components that define a Strategy are:

## Interface Strategy 🫱🏻🫲🏻
Defines a common interface, which will serve as a contract for all supported algorithms.

```java
public interface FastShippingStrategy {

    /* ------------------------------------------------------------------------------------------------------*/

    ReturnProcess processShipping(Long logId, Integration integration);

    /* ------------------------------------------------------------------------------------------------------*/
    
}
```

## ConcreteStrategy 🙅🏻‍♂️🙅🏻‍♀️🙍🏻‍♂️🙆🏻💁🏻‍♂️

These are the classes that implement the Strategy Interface and contain the specific logic of the algorithm.

```java
@Slf4j
public class IntegrationPayment implements FastShippingStrategy{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public ReturnProcess processShipping(Long logId, Integration integration) {
      
        log.info("Processing payment integration.");

        return ReturnProcess.builder()
        .idIntegration(integration.getId())
        .integrationName(integration.getName())
        .message("Success")
        .status(HttpStatus.OK)
        .build();
    }

    /* ------------------------------------------------------------------------------------------------------*/
    
}
```
```java
@Slf4j
public class IntegrationSent implements FastShippingStrategy{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public ReturnProcess processShipping(Long logId, Integration integration) {
      
        log.info("Processing sent integration.");

        return ReturnProcess.builder()
        .idIntegration(integration.getId())
        .integrationName(integration.getName())
        .message("Success")
        .status(HttpStatus.OK)
        .build();
    }

    /* ------------------------------------------------------------------------------------------------------*/
    
}
```
```java
@Slf4j
public class IntegrationSeparation implements FastShippingStrategy{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public ReturnProcess processShipping(Long logId, Integration integration) {
      
        log.info("Processing separation integration.");

        return ReturnProcess.builder()
        .idIntegration(integration.getId())
        .integrationName(integration.getName())
        .message("Success")
        .status(HttpStatus.OK)
        .build();
    }

    /* ------------------------------------------------------------------------------------------------------*/
    
}
```

## Context 🌍

It is a class that holds a reference to the Strategy Interface and is responsible for calling the Strategy method. The context can be a dedicated class or even a service class that, through a key-value data structure, invokes the desired algorithm using the keys in its structure.

An example of a context class using an existing service with a key-value data structure.

```java
@Service
@Slf4j
public class FastShippingServiceImpl implements FastShippingService{

    @Autowired
    private IntegrationRepository integrationRepository;

    private final Map<EnumName, FastShippingStrategy> fastStrategyMap = Map.of(

        EnumName.INTEGRATION_PAYMENT, new IntegrationPayment(),
        EnumName.INTEGRATION_SEPARATION, new IntegrationSeparation(),
        EnumName.INTEGRATION_SENT, new IntegrationSent()
    );

    
    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public List<ReturnProcess> processIntegration(Long logId, EnumName nameIntegration) {

        List<ReturnProcess> results = new ArrayList<>();
      
        log.info("Processing integration");

        integrationRepository.fetchIntegration(nameIntegration).forEach(integration -> {

            results.add(fastStrategyMap.get(nameIntegration).processShipping(logId, integration));
        });

        return results;

    }

    
    /* ------------------------------------------------------------------------------------------------------*/
    
}
```

In this way, we eliminate extensive conditional structures from the code, creating room for new functionalities to be implemented swiftly without affecting the current business model of the application. Additionally, it facilitates maintenance by concentrating the logic in a specific part of the code.


## When to use ⁉️

The Strategy design pattern is useful when you have a family of algorithms or behaviors and want to allow them to be chosen dynamically during program execution. Here are some scenarios where the Strategy pattern may be appropriate:

**Multiple Similar Algorithms:**<br>
When you have several classes that perform similar algorithms but with specific implementations, and you want the client to be able to choose between them.<br>
**Avoiding Duplicate Code:** <br>
If you notice that you have duplicate code in various parts of your system due to different implementations of the same algorithm, the Strategy pattern can help centralize common logic.<br>
**Dynamic Configuration:** <br>
When you need to dynamically configure an object with one of several behaviors. For example, in configuration systems where behavior can be chosen through parameters or settings.<br>
**Encapsulation of Variable Behavior:**<br>
hen you want to encapsulate a behavior that may vary and isolate it from other parts of the code. This facilitates maintenance and prevents changes in one behavior from affecting other parts of the system.<br>
**Ease of Extension:**<br>
If you expect to add new algorithms or behaviors without modifying existing code. The Strategy pattern allows for easy addition of new strategies without affecting existing code.<br>
**Testability:**<br>
When you want to facilitate unit testing by allowing easy substitution of implementations during tests.<br>

Whenever you realize that you are dealing with a situation where different algorithms or behaviors can be applied and you want to keep these options flexible, the Strategy pattern can be an appropriate choice. It helps promote code flexibility and maintenance, making it easier to include, remove, or modify strategies without impacting the rest of the system.

## Apache Maven

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

