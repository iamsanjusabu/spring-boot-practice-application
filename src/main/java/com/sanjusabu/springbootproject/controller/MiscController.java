package com.sanjusabu.springbootproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class MiscController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    // It doesn't work when CSRF is disabled in configuration
    @GetMapping("get-csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("get-session-id")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
