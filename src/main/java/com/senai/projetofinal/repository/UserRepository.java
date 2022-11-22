package com.senai.projetofinal.repository;

import com.senai.projetofinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
}
