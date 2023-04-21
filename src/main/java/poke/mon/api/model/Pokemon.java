package poke.mon.api.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter


public class Pokemon {
    private String name;
    private Integer weight;
    private List<TypeContainer> types;

    public Pokemon(){}
    public Pokemon(String name, Integer weight, List<TypeContainer> types) {
        this.name = name;
        this.weight = weight;
        this.types = types;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nome='" + name + '\'' +
                ", peso='" + weight + '\'' +
                ", tipo=" + types +
                '}';
    }
}
