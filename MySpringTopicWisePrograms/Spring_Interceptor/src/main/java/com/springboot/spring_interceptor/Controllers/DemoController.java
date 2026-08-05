package com.springboot.spring_interceptor.Controllers;

import com.springboot.spring_interceptor.Services.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping
    public ResponseEntity<String> DemoAction(){
        System.out.println("Controller called");
        String result = demoService.DemoAction();
        return ResponseEntity.ok(result);
    }
}
