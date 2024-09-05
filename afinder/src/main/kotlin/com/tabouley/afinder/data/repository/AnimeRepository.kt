package com.tabouley.afinder.data.repository

import com.tabouley.afinder.data.entity.AnimeEntity
import com.tabouley.afinder.data.mapper.AnimeEntityMapper
import com.tabouley.afinder.domain.entity.Anime
import com.tabouley.afinder.domain.usecase.GetAnimeListByTitleImpl
import com.tabouley.afinder.domain.usecase.GetAnimeListImpl
import com.tabouley.afinder.domain.usecase.SaveAnimeImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.apache.catalina.util.IOTools.flow
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface AnimeJpaRepository : JpaRepository<AnimeEntity, Long> {
    @Query("FROM AnimeEntity WHERE title LIKE %:title%")
    fun findByTitle(title: String): List<AnimeEntity>
}


@Repository
class AnimeRepositoryImpl(
    val animeJpaRepository: AnimeJpaRepository,
    val animeEntityMapper: AnimeEntityMapper
) : GetAnimeListImpl.AnimeRepository, SaveAnimeImpl.AnimeRepository, GetAnimeListByTitleImpl.AnimeRepository {

    @Transactional(readOnly = true)
    override fun findAll(): Flow<List<Anime>> = flow {
        val animeEntities = animeJpaRepository.findAll()
        val animes = animeEntityMapper.mapToDomainList(animeEntities)
        emit(animes)
    }

    override suspend fun save(anime: Anime): Anime {
        val animeEntity = animeEntityMapper.mapToEntity(anime)
        val savedAnimeEntity = animeJpaRepository.save(animeEntity)
        return animeEntityMapper.mapToDomain(savedAnimeEntity)
    }

    override fun findByTitle(title: String): Flow<List<Anime>> = flow {
        val animeEntities = animeJpaRepository.findByTitle(title)
        val animes = animeEntityMapper.mapToDomainList(animeEntities)
        emit(animes)
    }
}