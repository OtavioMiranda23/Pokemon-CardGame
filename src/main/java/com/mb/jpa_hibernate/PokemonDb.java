package com.mb.jpa_hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@Entity
@Table(name = "Pokemons")
public class PokemonDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPokemon;
    private String namePokemon;
    private double hp;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;
    private double weight;
    public PokemonDb(String namePokemon, double hp, double attack, double defense) {
        this.namePokemon = namePokemon;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }


}
