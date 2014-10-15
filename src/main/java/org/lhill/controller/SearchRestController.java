package org.lhill.controller;

/**
 * Created by Lucas on 10/15/2014.
 */
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchRestController {
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getGreeting(@RequestParam String query) {
        String result = "Hello " + query;
        return result;
    }
}