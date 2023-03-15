package com.bukhari.exceptionhandlingvalidation.service;

import com.bukhari.exceptionhandlingvalidation.entity.AppUser;
import com.bukhari.exceptionhandlingvalidation.globalexception.UserNotFoundException;
import com.bukhari.exceptionhandlingvalidation.repository.AppUserRepository;
import com.bukhari.exceptionhandlingvalidation.request.AppUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Global Exception Handling AppUserService
 */
@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;


    public AppUser saveUser(AppUserRequest userRequest) {
        AppUser user = new AppUser(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return appUserRepository.save(user);
    }


    public List<AppUser> getALlUsers() {
        return appUserRepository.findAll();
    }


    public AppUser getUser(int id) throws UserNotFoundException {
        Optional<AppUser> optional = appUserRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new UserNotFoundException("user not found with id : " + id);
        }
    }
}