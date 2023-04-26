package poke.mon.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)


public class Pokemon {

//    private List<Stats> stats;
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    private Integer weight;
    @JsonIgnore
    private List<TypeContainer> types;
    private  String primaryType;
    private  String secondaryType;
    @JsonIgnore
    private ArrayList<Stats> stats;

    public ArrayList<Stats> getStats() {
        return stats;
    }
    public Pokemon() {
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }


    public void updateStats() {
        for (Stats stat : stats) {
            switch (stat.getStat().getName()) {
                case  "hp":
                    setHp(stat.getBase_stat());
                    break;
                case "attack":
                    setAttack(stat.getBase_stat());
                    break;
                case "defense":
                    setDefense(stat.getBase_stat());
                    break;
                case "special-attack":
                    setSpecialAttack(stat.getBase_stat());
                    break;
                case "special-defense":
                    setSpecialDefense(stat.getBase_stat());
                    break;
                case "speed":
                    setSpeed(stat.getBase_stat());
            }
        }
    }
    public void updatePokemonTypes() {
        for(TypeContainer el : types) {
            switch (el.getSlot()) {
                case 1:
                    this.primaryType = el.getType().getName();
                    break;

                case 2:
                    this.secondaryType = el.getType().getName();
                    break;
            }
        }
    }

    public static class Stats {
        private int base_stat;
        private int effort;

        public int getEffort() {
            return effort;
        }

        public int getBase_stat() {
            return base_stat;
        }

        public DetailStats getStat() {
            return stat;
        }

        private DetailStats stat;
    }



    public static class DetailStats {
        private String name;
        private int baseStat;


        private String url;

        public String getName() {
            return name;
        }

    }


}
