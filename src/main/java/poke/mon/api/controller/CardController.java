package poke.mon.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import poke.mon.api.RegrasBatalhas.CalculoAtaque;
import poke.mon.api.model.Pokemon;

import java.util.ArrayList;

@RestController
@RequestMapping("/cards")
public class CardController {
    private RestTemplate restTemplate = new RestTemplate();
    private String url;
    ArrayList<Pokemon> listaRespose = new ArrayList();
    ArrayList<String> listaNomes = new ArrayList();
    ArrayList<String> listaStats = new ArrayList<>();
    ResponseEntity<String> response;

    @GetMapping
    public double getCards() throws JsonProcessingException {
        for (int i = 1; i < 20; i++) {
            
            url = "https://pokeapi.co/api/v2/pokemon/"+ i;
            response = this.restTemplate.getForEntity(url, String.class);
            String responseBody = response.getBody();
            Gson gson = new GsonBuilder().create();
            Pokemon pokemon = gson.fromJson(String.valueOf(responseBody), Pokemon.class);
            pokemon.updateStats();
            pokemon.updatePokemonTypes();
            listaRespose.add(pokemon);
        }

        CalculoAtaque ataque = new CalculoAtaque();
        double resultado = ataque.confrontoTypes(listaRespose.get(0), listaRespose.get(4));
        System.out.println(listaRespose.get(0).getPrimaryType() + " x " + listaRespose.get(4).getPrimaryType() + "ataque puro => " + listaRespose.get(0).getAttack());
        return resultado;



        //escolhe dois pokemons
//        Random random = new Random();
//        int index1 = random.nextInt(7);
//        int index2 = random.nextInt(7);
//        while (index1 == index2) {
//            index2 = random.nextInt(7);
//        }
//        Pokemon pokemon1 = listaRespose.get(index1);
//        Pokemon pokemon2 = listaRespose.get(index2);

        //interagir pokemons

//        if (pokemon1.getWeight() > pokemon2.getWeight()) {
//            return "o pokemon " + pokemon1.getName() + " é mais pesado que o pokemon " + pokemon2.getName();
//        } else {
//            return "o pokemon " + pokemon1.getName() + " não é é mais pesado que o pokemon " + pokemon1.getName();
//        }
//    }
//    private void showNames() {
//        for (Pokemon response : listaRespose) {
//            listaNomes.add(response.getName());
//        }


    }



}
