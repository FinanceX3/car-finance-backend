package com.sx84.finance.platform.financex3.profile.domain.service;

import com.sx84.finance.platform.financex3.profile.domain.model.Profile;
import com.sx84.finance.platform.financex3.profile.resource.CreateProfileResource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfileService {
    List<Profile> getAll();
    Page<Profile> getAll(Pageable pageable);

    Profile getById(Long id);
    Profile create(CreateProfileResource resource);
}
