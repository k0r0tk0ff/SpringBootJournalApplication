package ru.k0r0tk0ff.SpringBootJournalApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@Controller
public class ValueController {

    @Autowired
    private ValueRepository valueRepo;

    @RequestMapping("/asdf")
    public @ResponseBody
    List<Value> getValue() {
        return valueRepo.findAll();
    }

}
