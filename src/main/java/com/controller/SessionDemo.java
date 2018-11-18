package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class SessionDemo {

    @RequestMapping(value = "/d/logged", method = RequestMethod.GET)
    public String demo() {
        return "asd";
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String demo1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String sessionID = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionID);
        response.addCookie(cookie);
        session.setMaxInactiveInterval(3 * 60);
        System.out.println("session:" + session);
        System.out.println("sessionId:" + sessionID);
//        System.out.println(session.getAttribute("name"));

        return "hello ";
    }
}
