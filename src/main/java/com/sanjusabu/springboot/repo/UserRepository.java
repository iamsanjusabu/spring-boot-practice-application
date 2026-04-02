package com.sanjusabu.springboot.repo;

import com.sanjusabu.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByIdBetween(Long start, Long end);
}
