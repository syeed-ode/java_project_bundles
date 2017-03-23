package com.syeedode.authservices.wordreverser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WordController {

    @RequestMapping(value = "/reverse", method = RequestMethod.GET)
    public String getReverseWord(@RequestParam("word") String wordToReverse) {
        String a = new String();
        return Arrays.asList(wordToReverse.toCharArray())
                .stream()
                .map(c -> a.concat(String.valueOf(c)));
    }
}
