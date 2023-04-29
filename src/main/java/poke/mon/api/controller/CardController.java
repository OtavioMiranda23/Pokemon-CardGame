package poke.mon.api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
