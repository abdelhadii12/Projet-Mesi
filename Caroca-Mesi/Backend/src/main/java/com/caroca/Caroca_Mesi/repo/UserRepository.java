package com.caroca.Caroca_Mesi.repo;

import com.caroca.Caroca_Mesi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
