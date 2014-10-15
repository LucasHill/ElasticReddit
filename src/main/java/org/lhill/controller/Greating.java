package org.lhill.controller;

/**
 * Created by Lucas on 10/15/2014.
 */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/service/greeting")
public class Greating {
        @RequestMapping(value = "/{name}", method = RequestMethod.GET)
        public String getGreeting(@PathVariable String name) {
            String result="Hello "+name;
            return result;
        }
    }

