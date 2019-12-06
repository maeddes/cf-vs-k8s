package de.maeddes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/")
public class ExampleResource {

    @Value("${CF_INSTANCE_GUID:not_set}")
    String cfInstance;

    @Value("${HOSTNAME:not_set}")
    String hostname;

    @Value("${spring.profiles.active: none}")
    String profile;

    private String getInstanceId() {

        if (!hostname.equals("not_set"))
            return hostname;
        if (!cfInstance.equals("not_set"))
            return cfInstance;
        return "probably localhost";

    }

    @GetMapping("/")
    String hello() {

        return getInstanceId() + " Hallo, Novatec! (v1)";

    }

    @GetMapping("/fail")
    String fail() {

        System.exit(1);
        return "fixed!";
    }
}