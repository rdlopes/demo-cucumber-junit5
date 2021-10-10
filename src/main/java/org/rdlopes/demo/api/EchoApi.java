package org.rdlopes.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoApi {

    @GetMapping("")
    public String echo(@RequestParam String message) {
        return String.format("echo <%s>", message);
    }
}
