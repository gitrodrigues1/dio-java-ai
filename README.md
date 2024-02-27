<h1>
    <img width='40px' src='https://hermes.digitalinnovation.one/assets/diome/logo-minimized.png"'>
    
<h1>  
    <img width='40px' src='https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cleanpng.com%2Ffree%2Fjava-logo.html&psig=AOvVaw2jNqeiWxxvjYWD2C0cH_Iu&ust=1709134546781000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNCu2r3sy4QDFQAAAAAdAAAAABAF"'>
</h1>

API desenvolvida para o bootcamp JAVA AI Powered 

Projeto do Bootcamp:
[DIO Java AI Powered](https://web.dio.me/track/coding-future-tonnie-java-ai-powered)


[Publicando sua API REST na nuvem usando Spring Boot 3, Java 17 e Railway](https://web.dio.me/lab/publicando-sua-api-rest-na-nuvem-usando-spring-boot-3-java-17-e-railway/learning/7dc1b5d6-8b18-4df2-98c4-15de3939f2b7)

### Diagrama de classes

``` mermaid
classDiagram
    class Person {
        <<Data>>
        -String name
        -Account account
        -List<Feature> features
        -List<Card> card
        -List<News> news
    }
    class Account {
        <<Data>>
        -String number
        -String agency
        -float balance
        -float limit
    }
    class Feature {
        <<Data>>
        -String icon
        -String description
    }
    class Card {
        <<Data>>
        -String number
        -float limit
    }
    class News {
        <<Data>>
        -String icon
        -String description
    }

    Person --> Account
    Person --> Feature
    Person --> Card
    Person --> News
```