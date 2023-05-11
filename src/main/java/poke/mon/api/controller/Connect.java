package poke.mon.api.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.CorsConfig;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:3000")
@Getter
@RestController
public class Connect {
    private RestTemplate restTemplate = new RestTemplate();
    private String url;
    ArrayList<Pokemon> listaRespose = new ArrayList();

    ResponseEntity<String> response;

    public ArrayList<Pokemon> generateCards(int totalPokemons) {
        listaRespose = new ArrayList();
        for (int i = 1; i <= totalPokemons; i++) {

            url = "https://pokeapi.co/api/v2/pokemon/"+ i;
            response = this.restTemplate.getForEntity(url, String.class);
            String responseBody = response.getBody();
            Gson gson = new GsonBuilder().create();
            Pokemon pokemon = gson.fromJson(String.valueOf(responseBody), Pokemon.class);
            pokemon.updateStats();
            pokemon.updatePokemonTypes();

            listaRespose.add(pokemon);
        }

        return listaRespose;
    }
    @GetMapping("/pokemons")
    public ArrayList<Pokemon> listaPokemon() {
        ArrayList<Pokemon> pokemons = generateCards(10);
        return pokemons;
    }
}
