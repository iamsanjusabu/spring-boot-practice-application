package com.sanjusabu.springbootproject.repository;

import com.sanjusabu.springbootproject.entity.MyUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String email);
    Optional<MyUser> findByUsername(String username);

    @Query(value =
        """
        UPDATE user_table SET
        username = :username,
        password = :password,
        age = :age,
        gender = :gender,
        email = :email
        WHERE id = :id
        """, nativeQuery = true)
    @Modifying
    @Transactional
    int updateUser(
        @Param("id") Long id,
        @Param("username") String username,
        @Param("password") String password,
        @Param("age") int age,
        @Param("gender") char gender,
        @Param("email") String email);
}
