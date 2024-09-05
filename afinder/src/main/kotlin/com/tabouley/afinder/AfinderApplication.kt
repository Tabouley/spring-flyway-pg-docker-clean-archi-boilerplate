package com.tabouley.afinder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication(scanBasePackages = ["com.tabouley.afinder.di", "com.tabouley.afinder.data", "com.tabouley.afinder.presenter"])
@EnableJpaAuditing
class AfinderApplication
fun main(args: Array<String>) {
    runApplication<AfinderApplication>(*args)
}
