package com.example.soccer.domain

import io.micronaut.serde.annotation.Serdeable
import javax.persistence.*

@Serdeable
@Entity
data class Player (@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
                   @Column(name = "name", nullable = false) var name: String,
                   @Column(name = "age", nullable = false)  var age: Int)
    : Comparable<Player> {

    override fun compareTo(other: Player): Int {
        return 0
    }
}
