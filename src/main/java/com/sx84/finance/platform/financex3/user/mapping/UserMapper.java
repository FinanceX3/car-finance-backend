package com.sx84.finance.platform.financex3.user.mapping;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.sx84.finance.platform.financex3.profile.domain.model.Profile;
import com.sx84.finance.platform.financex3.profile.domain.persistence.ProfileRepository;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import com.sx84.finance.platform.financex3.user.domain.model.User;
import com.sx84.finance.platform.financex3.user.resource.CreateUserResource;
import com.sx84.finance.platform.financex3.user.resource.UpdateUserResource;
import com.sx84.finance.platform.financex3.user.resource.UserResource;

public class UserMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    @Autowired
    private ProfileRepository profileRepository;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource) {
        User user = mapper.map(resource, User.class);
        if (user != null && resource.getProfileId() != null) {
            Profile profile = profileRepository.findById(resource.getProfileId()).orElse(null);
            if (profile != null) {
                user.setProfile(profile);
            } else {
                // Manejar el caso en el que no se encuentre el perfil correspondiente
                // Puedes lanzar una excepción, asignar un valor predeterminado, etc.
            }
        }
        return user;
    }

    public User toModel(UpdateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}
