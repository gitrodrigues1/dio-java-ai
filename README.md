

API desenvolvida para o bootcamp JAVA AI Powered 

Projeto do Bootcamp:
[DIO Java AI Powered](https://web.dio.me/track/coding-future-tonnie-java-ai-powered)


### Tecnologias utilizadas:

- Java 17
- Spring Boot
- Spring Web
- Spring Data Jpa
- Postgres
- H2
- Swagger
- Github Actions

A API e o banco de dados foram postados na cloud do Railway e estão disponíveis no endereço, via Swagger:
[dio-java-ai-prd.up.railway.app](https://dio-java-ai-prd.up.railway.app/swagger-ui/index.html)


### Diagrama de classes

``` mermaid
classDiagram
    class Person {
        <<Data>>
        -String name
        -Account[] account
        -Feature[] features
        -Card card
        -News[] news
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

    Person "1" *--> "1" Account
    Person "1" *--> "N" Feature
    Person "1" *--> "1" Card
    Person "1" *--> "N" News
```
