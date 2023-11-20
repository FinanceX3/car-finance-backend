package com.sx84.finance.platform.financex3.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sx84.finance.platform.financex3.shared.exception.ResourceNotFoundException;
import com.sx84.finance.platform.financex3.shared.exception.ResourceValidationException;
import com.sx84.finance.platform.financex3.user.domain.model.User;
import com.sx84.finance.platform.financex3.user.domain.persistence.UserRepository;
import com.sx84.finance.platform.financex3.user.domain.service.UserService;
import com.sx84.finance.platform.financex3.user.mapping.UserMapper;
import com.sx84.finance.platform.financex3.user.resource.CreateUserResource;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper, Validator validator) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User create(CreateUserResource resource) {
        Set<ConstraintViolation<CreateUserResource>> violations = validator.validate(resource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //validation of brand and model

        User existingUser = userRepository.findByEmail(resource.getEmail());

        if (existingUser != null)
            throw new ResourceValidationException(ENTITY, "A user with this email already exists");

        return userRepository.save(mapper.toModel(resource));
    }
}
