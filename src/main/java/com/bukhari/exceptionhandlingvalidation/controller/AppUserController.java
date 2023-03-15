package com.bukhari.exceptionhandlingvalidation.controller;


import com.bukhari.exceptionhandlingvalidation.entity.AppUser;
import com.bukhari.exceptionhandlingvalidation.globalexception.UserNotFoundException;
import com.bukhari.exceptionhandlingvalidation.request.AppUserRequest;
import com.bukhari.exceptionhandlingvalidation.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<AppUser> saveUser(@RequestBody @Valid AppUserRequest userRequest){
        return new ResponseEntity<>(appUserService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.ok(appUserService.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(appUserService.getUser(id));
    }
}