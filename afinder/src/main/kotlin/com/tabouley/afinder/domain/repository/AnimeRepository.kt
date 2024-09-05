package com.tabouley.afinder.domain.repository

import com.tabouley.afinder.domain.entity.Anime

interface AnimeRepository {
    fun findAll(): List<Anime>
    fun findByTitle(title: String): Anime?
    fun findById(id: Long): Anime?

    fun save(anime: Anime): Anime
    fun delete(anime: Anime)
}