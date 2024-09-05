package com.tabouley.afinder.presenter.dto

data class AnimeDto(
    val id: Long?,
    val title: String,
    val description: String,
    val episodes: Int,
    val createdAt: String?
)
