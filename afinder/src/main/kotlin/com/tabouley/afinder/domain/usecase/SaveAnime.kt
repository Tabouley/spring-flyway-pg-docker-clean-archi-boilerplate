package com.tabouley.afinder.domain.usecase

import com.tabouley.afinder.domain.entity.Anime

interface SaveAnime {
    suspend operator fun invoke(anime: Anime): Anime
}

internal class SaveAnimeImpl(
    private val animeRepository: AnimeRepository,
): SaveAnime {

    interface AnimeRepository {
        suspend fun save(anime: Anime): Anime
    }

    override suspend fun invoke(anime: Anime): Anime = animeRepository.save(anime)
}