package com.bacsihai.springbootbackend.repository;

import com.bacsihai.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    void deleteAllByIdIsIn(long[] ids);
}
