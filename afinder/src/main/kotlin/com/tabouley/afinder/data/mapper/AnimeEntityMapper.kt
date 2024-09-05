package com.tabouley.afinder.data.mapper

import com.tabouley.afinder.data.entity.AnimeEntity
import com.tabouley.afinder.domain.entity.Anime
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface AnimeEntityMapper: EntityMapper<AnimeEntity, Anime> {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    override fun mapToEntity(domain: Anime): AnimeEntity

    override fun mapToDomain(entity: AnimeEntity): Anime
}