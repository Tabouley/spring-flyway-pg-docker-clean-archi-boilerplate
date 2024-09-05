package com.tabouley.afinder.presenter.mapper

interface DtoMapper<D, Dto> {
    fun mapToDto(domain: D): Dto
    fun mapToDomain(dto: Dto): D

    fun mapToDtoList(domainList: List<D>): List<Dto> {
        return domainList.map { mapToDto(it) }
    }

    fun mapToDomainList(dtoList: List<Dto>): List<D> {
        return dtoList.map { mapToDomain(it) }
    }
}