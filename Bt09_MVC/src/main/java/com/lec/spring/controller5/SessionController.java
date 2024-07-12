package com.lec.spring.controller5;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@Controller
@RequestMapping("/session")
public class SessionController {

    // HttpSession 객체
    //  현재 request 한 client 에 대한 Session 정보
    @RequestMapping("/list")
    public void list(HttpSession session, Model model){

        // 세션에 있는 '모든' attr names 들 뽑아내기
        // name: String 타입
        Enumeration<String> enumeration = session.getAttributeNames();

        StringBuffer buff = new StringBuffer();
        int i = 0;
        while(enumeration.hasMoreElements()){
            String sessionName = enumeration.nextElement();
            // session.getAttribute('name')  <-- 특정 세션 attr value 추출. 리턴타입 Object. 해당 name 이 없으면 null 리턴
            String sessionValue = session.getAttribute(sessionName).toString();
            buff.append((i + 1) + "] " + sessionName + " : " + sessionValue + "<br>");
            i++;
        }
        if(i == 0){
            buff.append("세션안에 attribute 가 없다.<br>");
        }
        model.addAttribute("result", buff.toString());
    }


    @RequestMapping("/create")
    public String create(HttpSession session){
        String sessionName, sessionValue;

        sessionName = "num1";
        sessionValue = "" + (int)(Math.random() * 100);

        // 세션 attr : name-value 생성
        // setAttribute(String name, Object value) 두번째 매개변수는 Object 타입이다
        session.setAttribute(sessionName, sessionValue);

        sessionName = "datetime";
        sessionValue = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        session.setAttribute(sessionName, sessionValue);

        return "redirect:/session/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session) {
        // removeAttribute(name) 세션 attribute 삭제
        session.removeAttribute("num1");

        return "redirect:/session/list";
    }



} // end controller