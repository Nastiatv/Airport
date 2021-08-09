package com.runa.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
        factoryBean.setResources(new Resource[]{new ClassPathResource("flight-data.json"), new ClassPathResource("cargo-data.json")});
        return factoryBean;
    }
}