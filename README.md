# InternetShop

## List of content
- [Description](#description)
- [Stack of technologies](#stack-of-technologies)
- [Installing](#installing)
- [Getting started](#getting-started)
- [Authors](#authors)
- [Licence](#licence)

## Description
Hello, anyone! This is my realization of internet shop, the purpose of that project was to 
create a simple web application focusing on back-end in Java, using and improving knowledge
in different technologies of web-development. <hr>
Talking about structure, project implements MVC pattern and have 3-Tier architecture: <p>
1. Data Tier - PosgreSQL DB and DAO's;
2. Application Tier - business logic in Java services;
3. Presentation Tier - Servlet Controllers and their JSP pages.
 
## Stack of technologies 
- Java 11
- Servlet 3.1
- PostgreSQL 12.0
- Hibernate 5.4.5
- Maven 4.0
- Tomcat 9.0.24
- Log4j 1.2.17

## Installing
1. Download project from this repository and add to IDE as Maven project;
2. Add project to your IDE as Maven project;
3. Install and configure Tomcat;
4. Install and configure PostgreSQL (make sure that password to default postgres user is "1111" OR
change variable _password_ in Factory.java);
5. Check same properties in hibernate.cfg.xml;
5. Run init_db.sql in database;
6. Make sure all dependencies from pom.xml are loaded;
7. [Optional] If you want to see logs - set log file in log4j.properties;
8. Finally run it!

## Getting started
First of all, you have to login. By default, you already have user
(login: @login, pass: 1111) with administrative rights, otherwise you can always create a new user
via registration form. <hr>
Now you can freely go shopping!

## Authors 
[Maxim Bezyazichny](https://github.com/SkaterWeather/)

## Licence
This project is MIT licensed. See the 
[license](https://github.com/SkaterWeather/InternetShop/blob/master/LICENCE) file.
