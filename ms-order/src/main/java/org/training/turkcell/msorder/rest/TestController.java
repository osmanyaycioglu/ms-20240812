package org.training.turkcell.msorder.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/hello/hello1")
    public String hello1() {
        return "hello1";
    }

    @PostMapping("/hello/hello1")
    public String hello2() {
        return "hello2";
    }


    @GetMapping("/hello/hello3")
    public String hello3(@RequestParam String name,
                         @RequestParam String surname) {
        return "hello3 " + name + " " + surname;
    }

    @GetMapping("/hello/hello4/{xyz}/{surname}")
    public String hello4(@PathVariable("xyz") String name,
                         @PathVariable String surname) {
        return "hello4 " + name + " " + surname;
    }

    @GetMapping("/hello/hello5/{xyz}")
    public String hello5(@PathVariable("xyz") String name,
                         @RequestParam String surname) {
        return "hello5 " + name + " " + surname;
    }

    @PostMapping("/hello/hello6")
    public String hello5(@RequestBody Person person) {
        return "hello6 " + person ;
    }

}
