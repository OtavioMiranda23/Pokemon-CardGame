package poke.mon.api.RegrasBatalhas;

public class TabelaTipos {
    int normal = TiposPokemons.Normal.ordinal();
    private int getIndexNormal = TiposPokemons.Normal.ordinal();
    private int getIndexFire = TiposPokemons.Fire.ordinal();
    private int getIndexWater = TiposPokemons.Water.ordinal();
    private int getIndexGrass = TiposPokemons.Grass.ordinal();
    private int getIndexElectric = TiposPokemons.Electric.ordinal();
    private int getIndexIce = TiposPokemons.Ice.ordinal();
    private int getIndexFighting = TiposPokemons.Fighting.ordinal();
    private int getIndexPoison = TiposPokemons.Poison.ordinal();
    private int getIndexGround = TiposPokemons.Ground.ordinal();
    private int getIndexFlying = TiposPokemons.Flying.ordinal();
    private int getIndexPsychic = TiposPokemons.Psychic.ordinal();
    private int getIndexBug = TiposPokemons.Bug.ordinal();
    private int getIndexRock = TiposPokemons.Rock.ordinal();
    private int getIndexGhost = TiposPokemons.Ghost.ordinal();
    private int getIndexDragon = TiposPokemons.Dragon.ordinal();
    private int getIndexDark = TiposPokemons.Dark.ordinal();
    private int getIndexSteel = TiposPokemons.Steel.ordinal();
    private int getIndexFairy = TiposPokemons.Fairy.ordinal();

    private  double[][] matrizTipo = {
            //    Nor  Fir  Wat  Gra  Ele  Ice  Fig  Po   Gro  Fly  Psy  Bug  Roc  Gho  Dra  Dar  Ste  Fai
            /*Nor*/ { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 1.0, 0.5, 1.0 },
            /*Fir*/ { 1.0, 0.5, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 2.0, 1.0 },
            /*Wat*/ { 1.0, 2.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0 },
            /*Gra*/ { 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 0.5, 1.0 },
            /*Ele*/ { 1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0 },
            /*Ice*/ { 1.0, 0.5, 0.5, 2.0, 1.0, 0.5, 2.0, 1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 0.5, 1.0 },
            /*Fig*/ { 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 2.0, 0.5, 0.0, 1.0, 2.0, 2.0, 2.0 },
            /*Po */ { 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0 },
            /*Gro*/ { 1.0, 2.0, 0.5, 2.0, 0.5, 1.0, 0.5, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0 },
            /*Fly*/ { 1.0, 1.0, 1.0, 0.5, 2.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0 },
            /*Psy*/ { 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 0.0, 1.0 },
            /*Bug*/ { 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 0.5, 0.5 },
            /*Roc*/ { 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0 },
            /*Gho*/ { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0 },
            /*Dra*/ { 1.0, 0.5, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 2.0 },
            /*Dar*/ { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.0, 1.0, 0.5, 2.0, 1.0 },
            /*Ste*/ { 1.0, 0.5, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5 },
            /*Fairy*/{ 1.0, 0.5, 1.0, 0.5, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 1.0 }
    };
    public void comparaTipos() {
         double comparacao = matrizTipo[getIndexWater][getIndexFire];
        System.out.println(TiposPokemons.Water + " x " + TiposPokemons.Fire + " = " + comparacao);

    }
    public void mostraVencedor() {
        TiposPokemons  vencedor;
        if (matrizTipo[getIndexWater][getIndexFire] > 1 ) {
            vencedor = TiposPokemons.Water;
        } else if (matrizTipo[getIndexWater][getIndexFire] == 1) {
            vencedor = null;
        } else {
            vencedor = TiposPokemons.Fire;
        }
        System.out.println("O vencedor entre " + TiposPokemons.Water + " x " + TiposPokemons.Fire + " é " + vencedor );
    }

    public static void main(String[] args) {
        TabelaTipos tipos = new TabelaTipos();
        tipos.comparaTipos();
        tipos.mostraVencedor();
    }
}
