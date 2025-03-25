package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
@Transactional
public class UserService {
   @Autowired
   private UserRepo userRepo;

   @Autowired
   private ModelMapper modelMapper;

   public List<UserDTO> getAllUser() {
      List<User>userList = userRepo.findAll();
      return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
   }

   public UserDTO saveUser(UserDTO userDTO){
      userRepo.save(modelMapper.map(userDTO, User.class));
      return userDTO;
   }
}
