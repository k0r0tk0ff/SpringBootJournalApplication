# SpringBootJournalApplication
### First application. Use SpringBoot + Web + JPA (H2)  

Схема работы программы - 

1) Создание таблицы в бд H2, маппинг переменных (см конструктор класса Journal) к колонкам таблицы  
2) Наполнение таблицы данными, см класс ApplicationRunner, блок кода с анотацией @BEAN  
3) Запуск embedded контейнета сервлетов TOMCAT, примапливание пути "/" в REST запросе к 
методу получения данных из БД "repo.findAll()" который стал доступен после использования интерфейса JpaRepository

>    @RequestMapping("/")  
>       public @ResponseBody List<Journal> getJournal() {  
>           return repo.findAll();  
>       }  
4) Ожидание REST запроса, при его получении выполнение логики REST controller-a по трансформации REST запроса в метод работы с БД  
5) Автоматическое преобразование ответа от БД в формат JSON и отправка его формирователю REST запроса  

##### ---------------------------------------------------------  
Описание структуры проекта
>  Services          - бизнеслогика  
>  Controllers       - REST controllers  
>  Repository        - хранилище данных  
>  Entities          - сущности (обьекты в java и определение их отображения в таблицы БД)  

Доп сведения:
src\main\resources\application.properties  
------  
server.port=8000  
server.contextPath=/project  
logging.level.ru/k0r0tk0ff=DEBUG  

# Data source properties  
spring.jpa.hibernate.ddl-auto=validate  
spring.jpa.show-sql=true  
------  

#### Про spring.jpa.hibernate.ddl-auto=validate  
В директории также лежали файлы с sql кодом "schema.sql", "data.sql"  
validate вероятнее всего сравнивает схему с той, что в "schema.sql".  
Также, вероятнее всего придеться выставить параметр не "validate"  
  

//--------------------- Секция с примером  
Здесь рельно работающий проект с H2, Spring-data, SpringBoot, @ManyToMany, @OneToMany  
https://gigsterous.github.io/engineering/2016/09/25/spring-boot-2.html  
https://github.com/gigsterous/gigy-example/releases/tag/v2  

https://docs.spring.io/spring-boot/docs/current/reference/pdf/spring-boot-reference.pdf

//--------------------- Секция заметок для исправления
classpath = SpringBootJournalApplication/src/main/java/  
Additional Classpath Elements -- http://maven.apache.org/surefire/maven-surefire-plugin/examples/configuring-classpath.html  
https://maven.apache.org/shared/maven-archiver/examples/classpath.html#Prefix

  
