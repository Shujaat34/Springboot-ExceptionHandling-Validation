package com.bukhari.exceptionhandlingvalidation.request;

import jakarta.validation.constraints.*;

/**
 * Global Exception Handling AppUserRequest
 */
public class AppUserRequest {
    @NotNull(message = "username must not be null")
    private String name;
    @Email(message = "Invalid email address, Please provide a valid email")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number, Please Provide a Valid Number")
    private String mobile;
    private String gender;
    @Min(value = 18, message = "Age must be 18 or greater")
    @Max(value = 60, message = "Age must be 60 or less")
    private int age;
    @NotBlank
    private String nationality;

    public AppUserRequest(String name, String email, String mobile, String gender, int age, String nationality) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
