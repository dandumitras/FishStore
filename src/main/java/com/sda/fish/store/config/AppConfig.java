package com.sda.fish.store.config;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.sda.fish.store")
@EntityScan("com.sda.fish.store.entities")
@EnableJpaRepositories("com.sda.fish.store.repositories")
public class AppConfig {

}
