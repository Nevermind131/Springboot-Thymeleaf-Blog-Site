package com.weiyu.controller;

import com.github.pagehelper.PageInfo;
import com.weiyu.entity.Type;
import com.weiyu.exception.NotFoundException;
import com.weiyu.service.TypeService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping({"/admin"})
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping({"/types"})
    public String types(Model model) throws Exception {
        PageInfo<Type> iPage = this.typeService.listType(1);
        model.addAttribute("page", iPage);
        return "admin/types";
    }


    @GetMapping({"/types/{currentPage}"})
    public String types(@PathVariable int currentPage, Model model) throws Exception {
        PageInfo<Type> iPage = this.typeService.listType(currentPage);
        model.addAttribute("page", iPage);
        return "admin/types";
    }

    @GetMapping({"/types/input"})
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }


    @PostMapping({"/types"})
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        Type type1 = this.typeService.getByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name", "nameError", "不能添加重复分类");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }
        boolean isSaved = this.typeService.save(type);
        if (isSaved) {

            attributes.addFlashAttribute("message", "新增成功");
        } else {

            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/types";
    }

    @GetMapping({"/types/{id}/input"})
    public String editInput(@PathVariable Long id, Model model) throws NotFoundException {
        model.addAttribute("type", this.typeService.getById(id));
        return "admin/types-input";
    }


    @PostMapping({"/types/{id}"})
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Type type1 = this.typeService.getByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name", "nameError", "不能添加重复分类");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }
        boolean isSaved = this.typeService.updateById(type);
        if (isSaved) {

            attributes.addFlashAttribute("message", "更新成功");
        } else {

            attributes.addFlashAttribute("message", "更新失败");
        }
        return "redirect:/admin/types";
    }

    @GetMapping({"/types/{id}/delete"})
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        this.typeService.removeById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
