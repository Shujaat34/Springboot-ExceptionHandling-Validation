package com.bukhari.exceptionhandlingvalidation.repository;

import com.bukhari.exceptionhandlingvalidation.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Global Exception Handling AppUserRepository
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

}
