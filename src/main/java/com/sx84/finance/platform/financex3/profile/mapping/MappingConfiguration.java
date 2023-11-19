package com.sx84.finance.platform.financex3.profile.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProfileMapper profileMapper() {
        return new ProfileMapper();
    }
}
