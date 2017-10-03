package ru.k0r0tk0ff.SpringBootJournalApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Journal;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.JournalRepository;

import java.util.List;

   /**.
   * Created by k0r0tk0ff on 9/27/2017.
   */

   /*
   * @Controller означает, что класс используется в качестве контроллера (service)
   */
@Controller
public class JournalController {

    /*
    * @Autowired означает, что BEAN типа "JournalRepository" будет создан автоматически, 
    * при необходимости его использования
    */
    @Autowired
    private JournalRepository repo;

    /*
     * For parsing "index.*" in /src/main/java/resources
     */
/*        @RequestMapping("/asdf")
    public String index(Model model){
        model.addAttribute("journal", repo.findAll());
        return "index";
    }*/

    /*
    * @ResponseBody означает, что метод возвращает содержимое ответ на REST запрос
    * Трансформация в JSON производиться автоматически
    */

    @RequestMapping("/")
    public @ResponseBody List<Journal> getJournal() {
        return repo.findAll();
    }
}

