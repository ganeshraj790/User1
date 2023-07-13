package com.ganesh.user.repo;


import com.ganesh.user.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


}
