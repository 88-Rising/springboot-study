package frank.controller;

import frank.model.Duck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")

public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public Duck login(String username,String password){
        System.out.printf("username=%s,password=%s\n",username,password);
        return  new Duck("LadyGaga",2);
    }

    @RequestMapping("/login2")
    public String login2(){
        return "login.html";
    }

    @RequestMapping("/login3")
    public String login3(){
        //重定向发送两次request请求，转发一次request请求
        //重定向会改变url，转发不会改变url
        //在tomcat中重定向可以定向到外边的信息，比如百度，但是转发只能访问内部文件
        return  "redirect:/user/login";
    }
}
