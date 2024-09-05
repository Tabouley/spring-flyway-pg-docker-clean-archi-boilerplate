package com.tabouley.afinder.presenter.mapper

import com.tabouley.afinder.domain.entity.Anime
import com.tabouley.afinder.presenter.dto.AnimeDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.time.format.DateTimeFormatter

@Mapper(componentModel = "spring")
interface AnimeDtoMapper: DtoMapper<Anime, AnimeDto> {

    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    override fun mapToDto(domain: Anime): AnimeDto

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    override fun mapToDomain(dto: AnimeDto): Anime
}
