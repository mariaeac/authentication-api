package com.meac.authentication_api.repository;

import com.meac.authentication_api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);


}
