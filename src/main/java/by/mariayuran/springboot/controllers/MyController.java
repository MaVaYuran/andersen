package by.mariayuran.springboot.controllers;

import by.mariayuran.springboot.ThisIsMyFirstConditionalBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired(required = false)
    private ThisIsMyFirstConditionalBean myBean;

    @GetMapping("/check-bean")
    public String checkBean() {
        if(myBean != null) {
            myBean.doSomething();
            return "Bean is active";
        }else {
            return "Bean is not active";
        }
    }
}
