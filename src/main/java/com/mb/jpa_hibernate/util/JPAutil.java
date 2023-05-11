package com.mb.jpa_hibernate.util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("poke");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
