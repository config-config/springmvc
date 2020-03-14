package cn.losemen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/3/12 - 14:09
 */
@Controller
@RequestMapping("/hellocontroller")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据
          model.addAttribute("msg","Hello");

        return "hello";
    }
}
