package frank.controller;

import frank.model.Duck;
import frank.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")

public class LoginController {
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Duck login(String username,String password){
        System.out.printf("username=%s,password=%s\n",username,password);
        return  new Duck("LadyGaga",2);
    }

    @RequestMapping(value = "/login_0",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Duck login_0(User user){
        System.out.printf("username=%s,password=%s\n",user.getUsername(),user.getPassword());
        return  new Duck("LadyGaga0",3);
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
