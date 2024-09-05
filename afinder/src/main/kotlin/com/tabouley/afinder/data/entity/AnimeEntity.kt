package com.tabouley.afinder.data.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "anime")
class AnimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(nullable = false)
    var title: String = ""

    @Column(length = 65000, nullable = false)
    var description: String = ""

    @Column(nullable = false)
    var episodes: Int = 0

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    var rating: Double = 0.0
}
