package com.sx84.finance.platform.financex3.user.domain.service;


import com.sx84.finance.platform.financex3.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);

    User getById(Long userId);
    User create(User user);
}
