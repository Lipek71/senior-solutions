package com.training360.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    final private HelloServices helloServices;

    @Autowired
    public HelloController(HelloServices helloServices) {
        this.helloServices = helloServices;
    }

    @GetMapping("")
    @ResponseBody
    public String sayHello() {
        return helloServices.sayHello();
    }
}
