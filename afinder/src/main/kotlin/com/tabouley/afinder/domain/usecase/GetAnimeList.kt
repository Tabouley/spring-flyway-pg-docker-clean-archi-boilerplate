package com.tabouley.afinder.domain.usecase

import com.tabouley.afinder.domain.entity.Anime
import kotlinx.coroutines.flow.Flow

interface GetAnimeList {
    operator fun invoke(): Flow<List<Anime>>
}

internal class GetAnimeListImpl(
    private val animeRepository: AnimeRepository,
): GetAnimeList {

    interface AnimeRepository {
        fun findAll(): Flow<List<Anime>>
    }

    override fun invoke(): Flow<List<Anime>> = animeRepository.findAll()
}