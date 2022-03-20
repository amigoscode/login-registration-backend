package com.example.demo.Chefprofile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefProfileRepository extends JpaRepository <Chef, Integer> {



    /*Chef findByEmailId(String chef_emailid);*/
}
