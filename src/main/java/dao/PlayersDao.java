package dao;

import com.mb.jpa_hibernate.PlayersDb;
import com.mb.jpa_hibernate.PokemonDb;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlayersDao {
    private EntityManager em;
    public PlayersDao (EntityManager em){
        this.em = em;
    }


    public void cadastrar(PlayersDb player) {
        this.em.persist(player);
    }
    public void cadastrar(PokemonDb pokemon) {
        this.em.persist(pokemon);
    }

    public PlayersDb buscarPorId(Long id){
        return em.find(PlayersDb.class, id);
    }
    public List<PlayersDb> buscarTodos() {
        String jpql = "SELECT p FROM PlayersTest p";
        return em.createQuery(jpql, PlayersDb.class).getResultList();
    }
    public List<PlayersDb> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM PlayersTest p WHERE p.namePlayer = :nome";
        return em.createQuery(jpql, PlayersDb.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
