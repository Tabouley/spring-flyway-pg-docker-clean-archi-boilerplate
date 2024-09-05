package com.tabouley.afinder.domain.usecase

import com.tabouley.afinder.domain.entity.Anime
import kotlinx.coroutines.flow.Flow

interface GetAnimeListByTitle {
    operator fun invoke(title: String): Flow<List<Anime>>
}

internal class GetAnimeListByTitleImpl(
    private val animeRepository: AnimeRepository,
) : GetAnimeListByTitle {

    interface AnimeRepository {
        fun findByTitle(title: String): Flow<List<Anime>>
    }

    override fun invoke(title: String): Flow<List<Anime>> = animeRepository.findByTitle(title)
}