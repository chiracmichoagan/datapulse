package bj.higfiveuniversity.datapulse.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.higfiveuniversity.datapulse.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
