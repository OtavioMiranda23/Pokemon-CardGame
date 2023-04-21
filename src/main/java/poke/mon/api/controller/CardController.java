package poke.mon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/cards")
public class CardController {
    private RestTemplate restTemplate = new RestTemplate();
    private String url;
    ArrayList<Pokemon> listaRespose = new ArrayList();
    ArrayList<String> listaNomes = new ArrayList();
    ResponseEntity<Pokemon> response;

    @GetMapping
    public String getCards() {
        for (int i = 1; i < 8; i++) {
            url = "https://pokeapi.co/api/v2/pokemon/"+i;
            response = this.restTemplate.getForEntity(this.url, Pokemon.class);
            Pokemon pokemonResponse = response.getBody();
            Pokemon pokemon = new Pokemon(pokemonResponse.getName(), pokemonResponse.getWeight(), pokemonResponse.getTypes());
            this.listaRespose.add(pokemon);
        }
        //escolhe dois pokemons
        Random random = new Random();
        int index1 = random.nextInt(7);
        int index2 = random.nextInt(7);
        while (index1 == index2) {
            index2 = random.nextInt(7);
        }
        Pokemon pokemon1 = listaRespose.get(index1);
        Pokemon pokemon2 = listaRespose.get(index2);

        //interagir pokemons

        if (pokemon1.getWeight() > pokemon2.getWeight()) {
            return "o pokemon " + pokemon1.getName() + " é mais pesado que o pokemon " + pokemon2.getName();
        } else {
            return "o pokemon " + pokemon1.getName() + " não é é mais pesado que o pokemon " + pokemon1.getName();
        }
    }
    private void showNames() {
        for (Pokemon response : listaRespose) {
            listaNomes.add(response.getName());
        }


    }

}
