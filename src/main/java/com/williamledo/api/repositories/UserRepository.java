package com.williamledo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.williamledo.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
