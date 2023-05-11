package com.mb.jpa_hibernate;

import com.mb.jpa_hibernate.util.JPAutil;
import dao.PlayersDao;
import jakarta.persistence.EntityManager;


public class Controller {
    public static void cadastrarPlayer() {

        var pokemon1 = new PokemonDb("Onix", 60.0, 20.0, 15.0);
        var pokemon2 = new PokemonDb("Pikachu", 80.0, 150.0, 15.0);
        var pokemon3 = new PokemonDb("Chalyzard", 70.0, 10.0, 30.0);

        var players = new PlayersDb("Jair",  pokemon1 );
        var players2 = new PlayersDb("Lula", pokemon2);
        var players3 = new PlayersDb("Ciro", pokemon3);

        EntityManager em = JPAutil.getEntityManager();
        PlayersDao dao = new PlayersDao(em);
        em.getTransaction().begin();
        dao.cadastrar(players);
        dao.cadastrar(players2);
        dao.cadastrar(players3);

        dao.cadastrar(pokemon1);
        dao.cadastrar(pokemon2);
        dao.cadastrar(pokemon3);
        em.getTransaction().commit();
        em.close();
        System.out.println("DEU CERTOOOOO");

    }
    public static void main(String[] args)  {
        cadastrarPlayer();
//        EntityManager em = JPAutil.getEntityManager();
//        PlayersDao dao = new PlayersDao(em);
//
//        PlayersTest player = dao.buscarPorId(1l);
//        List<PlayersTest> todos = dao.buscarTodos();
//        todos.forEach(playerAll -> System.out.println(playerAll.getNamePlayer()));
//        todos.forEach(playerAll -> System.out.println(playerAll.getCartaEscolhida()));





    }
}
