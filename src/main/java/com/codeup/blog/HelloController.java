package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


    @GetMapping("/hello{name}")
    @ResponseBody
    public String sayhello(@PathVariable String name) {
        return "Hello from Spring " + name + "!";
    }
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
}