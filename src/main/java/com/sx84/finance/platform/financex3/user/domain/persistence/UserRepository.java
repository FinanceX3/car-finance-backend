package com.sx84.finance.platform.financex3.user.domain.persistence;

import com.sx84.finance.platform.financex3.user.domain.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
