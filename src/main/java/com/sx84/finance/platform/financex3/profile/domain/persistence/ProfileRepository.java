package com.sx84.finance.platform.financex3.profile.domain.persistence;

import com.sx84.finance.platform.financex3.profile.domain.model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByDni(String dni);
}
