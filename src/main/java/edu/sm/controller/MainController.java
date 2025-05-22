package edu.sm.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {


    @Value("${app.url.server-url}")
    String serverurl;

    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("charturl", serverurl);
        model.addAttribute("serverurl", serverurl);

        return "index";
    }
    @RequestMapping("/websocket")
    public String websocket(Model model){
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center","websocket");
        return "index";
    }
    @RequestMapping("/chat")
    public String chat(Model model){
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center","chat");
        return "index";
    }



    @RequestMapping("/webrtc")
    public String rtc(Model  model) {
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("roomid","1");
        model.addAttribute("center", "webrtc");
        return "index";
    }
}
