package com.example.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "api/v1/")
@CrossOrigin
public class userContoller {
   @Autowired
   private UserService userService;

   @GetMapping("/getUser")
   public List<UserDTO> getUser(){
      return userService.getAllUser();
   }
}
