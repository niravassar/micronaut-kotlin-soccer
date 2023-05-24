package com.example.soccer.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.serde.annotation.Serdeable
import javax.persistence.*

@Serdeable
@Entity
data class SoccerGame(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
                      @Column(name = "name", nullable = false) var name: String,
                      @Column(name = "minPlayers") var minPlayers: Int,
                      @Column(name = "maxPlayers") var maxPlayers: Int) {
    @JsonIgnore
    @OneToMany(cascade = [CascadeType.ALL])
    var playerPool: MutableSet<Player> = mutableSetOf()

    fun addPlayerToPlayerPool(player: Player) {
        playerPool.add(player)
    }
}