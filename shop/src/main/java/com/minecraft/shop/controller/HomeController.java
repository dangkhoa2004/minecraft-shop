/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minecraft.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author 04dkh
 */

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        System.out.println("HOME PAGE");
        return "index";
    }
}
