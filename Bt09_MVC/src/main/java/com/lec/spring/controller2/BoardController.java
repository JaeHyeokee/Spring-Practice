package com.lec.spring.controller2;

import com.lec.spring.common.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
    @RequestMapping("/list")   // URL mapping -> "/member" + "/save" => "/member/save"
    public void listBoard() {
    }
    @RequestMapping("/write")   //  /member + /load => /member/load
    public void writeBoard() {
    }

    @RequestMapping("/detail")
    public void detailBoard() {
    }

    @RequestMapping("/update")
    public void updateBoard() {
    }

    @RequestMapping("/delete")
    public void deleteBoard() {
    }
}