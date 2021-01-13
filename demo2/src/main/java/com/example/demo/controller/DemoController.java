package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.base.BaseController;
import com.example.demo.entity.ObjectInventory;
import com.example.demo.service.DemoService;

@Controller
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/dbtest")
    public String dbTest(Model model) {
    	
        List<ObjectInventory> list = demoService.selectObjectInventory();
        model.addAttribute("objectInventory", list);
        
        List<ObjectInventory> rsList = demoService.selectRsObjectInventory(30); // 在庫数：30        
        model.addAttribute("rsObjectInventory", rsList);

        return "db_test";
    }

}