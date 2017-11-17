package com.xw.io.springboot.servlet.stack.service;

import com.xw.io.springboot.servlet.stack.model.Person;
import org.springframework.stereotype.Service;

/**
 * Created by xiaowei.liu on 17/11/2017.
 */
@Service
public class PersonService implements IPersonService {
    @Override
    public Person getPersonDetail(Integer id) {
        Person p = new Person();
        p.setId(id);
        p.setLocation("Varanasi");
        p.setName("Ram");
        return p;
    }
}
