package cn.lanqiao.finalTest.controller;


import cn.lanqiao.finalTest.Utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping("/login")
    public ResponseUtils login(){
        return null;
    }
}
