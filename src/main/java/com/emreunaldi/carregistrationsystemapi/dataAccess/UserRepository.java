package com.emreunaldi.carregistrationsystemapi.dataAccess;

import com.emreunaldi.carregistrationsystemapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username=:username")
    User getByUsername(@Param("username") String username);

}
