package com.khsdc.DR4.repository;

import com.khsdc.DR4.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
