package poke.mon.api.RegrasBatalhas;

public enum TiposPokemons {Normal, Fire, Water, Grass, Electric, Ice, Fighting, Poison, Ground, Flying, Psychic, Bug,
    Rock, Ghost, Dragon, Dark, Steel, Fairy,


}
class Main {
    public static void main(String[] args) {
        TiposPokemons[] tipos = TiposPokemons.values();
        for ( TiposPokemons tipo : tipos) {
            System.out.println("private " + "int " + "getIndex" + tipo + " = "  + "TiposVencedores." + tipo + ".ordinal();");

        }
    }
}
