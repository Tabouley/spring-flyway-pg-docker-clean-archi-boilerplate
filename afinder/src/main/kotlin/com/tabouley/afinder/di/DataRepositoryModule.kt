package com.tabouley.afinder.di

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EntityScan(basePackages = ["com.tabouley.afinder.data.entity"])
@EnableJpaRepositories(basePackages = ["com.tabouley.afinder.data.repository"])
class DataRepositoryModule {
}