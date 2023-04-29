package poke.mon.api.RegrasBatalhas;

import poke.mon.api.model.Pokemon;

public class CalculoAtaque {
    private int ataqueFinal;
    private TabelaTipos tabela = new TabelaTipos();
    public double attack(Pokemon pokemon1, Pokemon pokemon2) {
        String nome1 = pokemon1.getPrimaryType();
        String nome2 = pokemon2.getPrimaryType();

        int index1 = tabela.getIndex(nome1);
        int index2 = tabela.getIndex(nome2);
        double multiplicadorTipo = tabela.getValueConffront(index1, index2);
        double ataqueMultiplicado = pokemon1.getAttack() * multiplicadorTipo;


        double danoSofrido =  ataqueMultiplicado - pokemon2.getDefense();

        pokemon2.setHp(pokemon2.getHp() - danoSofrido);

        return ataqueMultiplicado;
    }

}
