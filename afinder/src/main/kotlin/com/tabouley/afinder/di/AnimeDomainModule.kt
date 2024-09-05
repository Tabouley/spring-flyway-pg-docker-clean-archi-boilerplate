package com.tabouley.afinder.di

import com.tabouley.afinder.domain.usecase.*
import com.tabouley.afinder.domain.usecase.GetAnimeListByTitleImpl
import com.tabouley.afinder.domain.usecase.GetAnimeListImpl
import com.tabouley.afinder.domain.usecase.SaveAnimeImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AnimeDomainModule {
    @Bean
    internal fun getAnimeList(animeRepository: GetAnimeListImpl.AnimeRepository): GetAnimeList {
        return GetAnimeListImpl(animeRepository)
    }

    @Bean
    internal fun saveAnime(animeRepository: SaveAnimeImpl.AnimeRepository): SaveAnimeImpl {
        return SaveAnimeImpl(animeRepository)
    }

    @Bean
    internal fun getAnimeListByTitle(animeRepository: GetAnimeListByTitleImpl.AnimeRepository): GetAnimeListByTitle {
        return GetAnimeListByTitleImpl(animeRepository)
    }
}