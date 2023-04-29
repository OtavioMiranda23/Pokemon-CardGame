package poke.mon.api.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;
@Getter
public class Connect {
    private RestTemplate restTemplate = new RestTemplate();
    private String url;
    ArrayList<Pokemon> listaRespose = new ArrayList();

    ResponseEntity<String> response;
    public ArrayList<Pokemon> generateCards(int totalPokemons) {
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
}
