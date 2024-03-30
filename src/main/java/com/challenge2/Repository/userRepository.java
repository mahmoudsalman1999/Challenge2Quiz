package com.challenge2.Repository;

import com.challenge2.Entity.Clients;
import com.challenge2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
