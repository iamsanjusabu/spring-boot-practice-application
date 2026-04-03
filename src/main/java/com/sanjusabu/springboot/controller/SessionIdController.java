package com.sanjusabu.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionIdController {

    @GetMapping("/api/session-id")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
