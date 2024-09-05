package com.tabouley.afinder.presenter.controller

import com.tabouley.afinder.domain.usecase.GetAnimeList
import com.tabouley.afinder.domain.usecase.GetAnimeListByTitle
import com.tabouley.afinder.domain.usecase.SaveAnime
import com.tabouley.afinder.presenter.dto.AnimeDto
import com.tabouley.afinder.presenter.mapper.AnimeDtoMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/animes")
class AnimeController(
    private val getAnimeList: GetAnimeList,
    private val getAnimeListByTitle: GetAnimeListByTitle,
    private val saveAnime: SaveAnime,
    private val animeDtoMapper: AnimeDtoMapper
) {

    @OptIn(ExperimentalCoroutinesApi::class)
    @GetMapping
    suspend fun getAllAnimes(): ResponseEntity<List<AnimeDto>> {
        val animeDomainList = getAnimeList().flatMapConcat { it.asFlow() }.toList()
        val animeDtoList = animeDtoMapper.mapToDtoList(animeDomainList)
        return ResponseEntity(animeDtoList, HttpStatus.OK)
    }

    @GetMapping("/{title}")
    suspend fun getAnimesByTitle(@PathVariable title: String): ResponseEntity<List<AnimeDto>> {
        val animeDomainList = getAnimeListByTitle(title).flatMapConcat { it.asFlow() }.toList()
        val animeDtoList = animeDtoMapper.mapToDtoList(animeDomainList)
        return ResponseEntity(animeDtoList, HttpStatus.OK)
    }

    @PostMapping
    suspend fun saveAnime(@RequestBody animeDto: AnimeDto): ResponseEntity<AnimeDto> {
        val anime = animeDtoMapper.mapToDomain(animeDto)
        val entity = saveAnime(anime)
        val dto = animeDtoMapper.mapToDto(entity)

        return ResponseEntity(dto, HttpStatus.CREATED)
    }
}
