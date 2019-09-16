package com.plato.websocketdemo.controller;

import com.plato.websocketdemo.ProductWebSocket;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello,this is websocket demo!";
    }

    @GetMapping("/test")
    public String test(String userId,String message) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            return "用户id不能为空！";
        }

        if (StringUtils.isEmpty(message)) {
            return "发送消息不能为空！";
        }

        new ProductWebSocket().systemSendToUser(userId,message);
        return "发送成功";
    }

    @RequestMapping("/ws")
    public ModelAndView ws() {
        ModelAndView model = new ModelAndView();
        model.setViewName("ws");
        return model;
    }

    @RequestMapping("/ws1")
    public ModelAndView ws1() {
        ModelAndView model = new ModelAndView();
        model.setViewName("ws1");
        return model;
    }
}
