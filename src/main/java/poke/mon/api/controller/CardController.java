package poke.mon.api.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poke.mon.api.dinamicasBatalha.Player;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;

@RestController
@RequestMapping("/cards")
public class CardController {


    @GetMapping
    public ArrayList<Pokemon> getCards() {
        var conexao = new Connect();
        conexao.generateCards(10);
        ArrayList<Pokemon> listaPokemons = conexao.getListaRespose();
        return listaPokemons;
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        String name = player.getName();
        Pokemon cartaEscolhida = player.getCartaEscolida();


        Player novoPlayer = new Player(name, cartaEscolhida);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
}
