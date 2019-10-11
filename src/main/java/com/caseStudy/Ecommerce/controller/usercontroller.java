package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/apl")
@CrossOrigin(origins="http://localhost:4200")
public class usercontroller {
    @Autowired
    userrepository ul;
    @PostMapping("/sign")
    public login createNewuser(@Valid @RequestBody login ifc)
    {
        ifc.setActive(1);
        ifc.setRole("user");
        return ul.save(ifc);
    }
    @GetMapping("/validateuser")
    public String validate()
    {
        return "\"user is valid\"";
    }


}
