package com.sx84.finance.platform.financex3.profile.mapping;

import com.sx84.finance.platform.financex3.profile.domain.model.Profile;
import com.sx84.finance.platform.financex3.profile.resource.ProfileResource;
import com.sx84.finance.platform.financex3.profile.resource.CreateProfileResource;
import com.sx84.finance.platform.financex3.profile.resource.UpdateProfileResource;
import com.sx84.finance.platform.financex3.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ProfileMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public ProfileResource toResource(Profile model) {
        return mapper.map(model, ProfileResource.class);
    }

    public Profile toModel(CreateProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }

    public Profile toModel(UpdateProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }

    public Page<ProfileResource> modelListPage(List<Profile> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProfileResource.class), pageable, modelList.size());
    }
}
