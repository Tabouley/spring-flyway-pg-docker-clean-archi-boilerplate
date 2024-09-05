package com.tabouley.afinder.domain.entity

import java.time.LocalDateTime

data class Anime(
    val id: Long?,
    val title: String,
    val description: String,
    val episodes: Int,
    val createdAt: LocalDateTime?
)
