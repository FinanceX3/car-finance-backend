package com.sx84.finance.platform.financex3.user.api;

import com.sx84.finance.platform.financex3.user.domain.service.UserService;
import com.sx84.finance.platform.financex3.user.mapping.UserMapper;
import com.sx84.finance.platform.financex3.user.resource.UserResource;
import com.sx84.finance.platform.financex3.user.resource.CreateUserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Create and read users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;


    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        return mapper.modelListPage(userService.getAll(), pageable);
    }

    @Operation(summary = "Get all users")
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Create user", responses = {
            @ApiResponse(description = "User successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(resource)), HttpStatus.CREATED);
    }

}
