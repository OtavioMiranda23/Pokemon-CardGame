package poke.mon.api.dinamicasBatalha;
import lombok.Getter;
import lombok.Setter;
import poke.mon.api.RegrasBatalhas.CalculoAtaque;
import poke.mon.api.model.Pokemon;

import java.util.Random;
@Getter
@Setter
public class DinamicaBatalha {
    private Player player1;
    private Player player2;
    private boolean primeiroPlayerJoga = true;
    private Table table;
    private boolean jogoEmAndamento;
    private int playerAtivo = 1;

    public void iniciarJogo() {
        player1 = new Player();
        player2 = new Player();
        this.table = new Table();
        quemComecaJogando();
        jogoEmAndamento = true;
        //O jogador ativo seleciona uma carta do seu deck para jogar na mesa;
        if (this.playerAtivo == 1) {
            player1.escolheCartaPlayer1(1, this.table);
        }        if (this.playerAtivo == 2) {
            player1.escolheCartaPlayer2(2, this.table);
        }
    }
    private void quemComecaJogando() {
        Random random = new Random();
        boolean num_random = random.nextInt(2) == 0 ? false : true;
        this.primeiroPlayerJoga = num_random;
    }
    public void jogarTurno() {

        atacar();

        verifcarFim();
        this.playerAtivo = this.playerAtivo == 1 ? 2 : 1;


    }
    public  void atacar() {
        var ataque = new CalculoAtaque();
        Pokemon carta1 = player1.getCartaEscolida();
        Pokemon carta2 = player2.getCartaEscolida();
        if (this.playerAtivo == 1) {
            ataque.attack(carta1, carta2);
        }
        if (this.playerAtivo == 2) {
            ataque.attack(carta2, carta1);
        }
    }
    public void verifcarFim() {

        if (this.getPlayer1().isDead() == true) {
            this.jogoEmAndamento = false;
            declaraVencedor(player2);
        }
        if (this.getPlayer2().isDead() == true) {
            this.jogoEmAndamento = false;
            declaraVencedor(player1);
        }
    }
    private void declaraVencedor(Player player) {
            player.setVencedor(true);

    }

}

