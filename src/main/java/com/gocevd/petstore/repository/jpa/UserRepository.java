package com.gocevd.petstore.repository.jpa;

import com.gocevd.petstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
