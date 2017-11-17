package com.xw.io.springboot.servlet.stack.controller;

import com.xw.io.springboot.servlet.stack.model.Person;
import com.xw.io.springboot.servlet.stack.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaowei.liu on 17/11/2017.
 */
@RestController
public class PersonController {
    @Autowired
    private IPersonService personService;
    @RequestMapping("/person")
    public Person getPersonDetail(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) {
        Person p = personService.getPersonDetail(id);
        return p;
    }
}
