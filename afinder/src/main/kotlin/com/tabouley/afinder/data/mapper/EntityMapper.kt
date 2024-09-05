package com.tabouley.afinder.data.mapper

import org.springframework.stereotype.Component

interface EntityMapper<E, D> {
    fun mapToEntity(domain: D): E
    fun mapToDomain(entity: E): D

    fun mapToEntityList(domainList: List<D>): List<E> {
        return domainList.map { mapToEntity(it) }
    }

    fun mapToDomainList(entityList: List<E>): List<D> {
        return entityList.map { mapToDomain(it) }
    }

}