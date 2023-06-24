# TestBook

### Технологии:
* Java 11
* Spring
* Spring MVC
* Hibernate
* MySQL

### Запуск приложения

- Для запуска приложения локально на Windows выполните команды
    1. maven clean install в IntelijIdea
    2. java -jar D:\Documents\Skillbox\TestBook\target\demo-0.0.1-SNAPSHOT.jar в командной строке, укажите путь к jar файлу в папке target

### Зависимости

* Spring Boot Starter
* Spring Boot Starter Web
* Jackson Databind - используется для преобразования JSON в POJO и обратно с помощью доступа к свойствам или с помощью аннотаций
* MapStruct Core - библиотека для автоматической генерации классов сопоставления компонентов 
* Lombok - генерация шаблонного кода с помощью аннотаций
* MySQL Connector Java - библиотека для обработки преобразований между типами данных MySQL и типами данных Java