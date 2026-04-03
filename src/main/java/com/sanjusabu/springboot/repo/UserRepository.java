package com.sanjusabu.springboot.repo;

import com.sanjusabu.springboot.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

    List<MyUser> findByIdBetween(Long start, Long end);
    Optional<MyUser> findByName(String name);
}
