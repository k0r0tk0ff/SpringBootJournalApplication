# SpringBootJournalApplication
>>First application. Use SpringBoot + Web + JPA (H2)  

Схема работы программы - 

1) Создание таблицы в бд H2, маппинг переменных (см конструктор класса Journal) к колонкам таблицы  
2) Наполнение таблицы данными, см класс ApplicationRunner, блок кода с анотацией @BEAN  
3) Запуск embedded контейнета сервлетов TOMCAT, примапливание пути "/" в REST запросе к методу получения данных из БД  

>> @RequestMapping("/")
>>    public @ResponseBody List<Journal> getJournal() {
>>        return repo.findAll();
>>    }  
4) Ожидание REST запроса, при его получении выполнение логики REST controller-a по трансформации REST запроса в метод работы с БД  
5) Автоматическое преобразование ответа от БД в формат JSON и отправка его формирователю REST запроса  
