package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ally.invoicify.models.UserLogin;

public interface UserRepository extends JpaRepository<UserLogin, Integer> {

}
