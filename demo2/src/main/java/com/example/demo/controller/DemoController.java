package com.example.demo.controller;

import java.util.List;

import com.example.demo.controller.base.BaseController;
import com.example.demo.entity.ObjectInventory;
import com.example.demo.mapper.ObjectInventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController  extends BaseController {
    @Autowired
    ObjectInventoryMapper objectInventoryMapper;

    @RequestMapping("/dbtest")
    public String dbTest(Model model) {
        List<ObjectInventory> list = objectInventoryMapper.selectAll();
        model.addAttribute("objectInventory", list);
        return "db_test";
    }
}