
package com.weiyu.controller;


import com.weiyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutShowController {


    @Autowired
    private UserService userService;

    @GetMapping({"/about"})
    public String about(Model model) {
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));

        /* 11 */
        return "about";

    }

}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\AboutShowController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */