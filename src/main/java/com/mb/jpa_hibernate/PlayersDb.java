package com.mb.jpa_hibernate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Getter
@Entity
@Table(name="players")
@NoArgsConstructor
public class PlayersDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPlayers;
    @OneToOne
    @JoinColumn(name = "namePokemon")
    private PokemonDb namePokemon;
    private String namePlayer;


    private boolean vencedor;
    private boolean isDead;



    public PlayersDb(String namePlayer, PokemonDb namePokemon) {
        this.namePlayer = namePlayer;
        this.namePokemon = namePokemon;
        this.vencedor = false;
        this.isDead = false;
    }
}
