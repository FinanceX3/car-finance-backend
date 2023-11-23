package com.sx84.finance.platform.financex3.user.domain.service;


import com.sx84.finance.platform.financex3.user.domain.model.User;
import com.sx84.finance.platform.financex3.user.resource.CreateUserResource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);

    User getById(Long userId);
    User create(CreateUserResource resource);
    User getByEmailAndPassword(String email, String password);
}
