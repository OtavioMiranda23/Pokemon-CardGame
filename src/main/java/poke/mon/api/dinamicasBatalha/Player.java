package poke.mon.api.dinamicasBatalha;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import poke.mon.api.RegrasBatalhas.CalculoAtaque;
import poke.mon.api.controller.Connect;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;
@NoArgsConstructor
@RestController
@Getter
public class Player {
    private  String name;
    private boolean isDead;

    public boolean isDead() {
        return isDead;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Pokemon cartaEscolida;
    private ArrayList<Pokemon> deck;
    private boolean vencedor;
    private Table table = new Table();
    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }

    //Constructor
    public Player(String name, Pokemon cartaEscolida) {
        this.name = name;
        this.cartaEscolida = cartaEscolida;


    }

    public void  montaDeck(Connect conexao) {
        conexao.generateCards(5);
        deck = conexao.getListaRespose();
    }
    public void escolheCartaPlayer1(int idCarta, Table table) {
        this.cartaEscolida = deck.get(idCarta);
        table.setCardPlayer1(cartaEscolida);

    }
    public void escolheCartaPlayer2(int idCarta, Table table) {
        this.cartaEscolida = deck.get(idCarta);
        table.setCardPlayer2(cartaEscolida);

    }
    public void died() {
        if (cartaEscolida.getHp() <= 0) {
            isDead = true;
        }
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        String name = getName();
        Pokemon cartaEscolhida = getCartaEscolida();


        Player novoPlayer = new Player(name, cartaEscolhida);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }





}
