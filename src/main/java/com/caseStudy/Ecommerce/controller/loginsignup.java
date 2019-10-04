package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.items;
import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.repository.loginrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/apl")
public class loginsignup {
    @Autowired
loginrepository al;
    @GetMapping("/log")
    public List<login> getAllLogins()
    {
        return al.findAll();
    }
    @PostMapping("/add")
    public login createNewItem(@Valid @RequestBody login al1)
    {
        return al.save(al1);
    }

}
