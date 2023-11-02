package com.example.database.utils;

import com.example.database.entities.Client;
import com.example.database.entities.Planet;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil is a utility class for managing Hibernate SessionFactory.
 */
@Getter
public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    /**
     * Private constructor to create a HibernateUtil instance and initialize the SessionFactory.
     */
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    static {
        INSTANCE = new HibernateUtil();
    }

    /**
     * Get the instance of HibernateUtil.
     *
     * @return The HibernateUtil instance.
     */
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Close the SessionFactory and release its resources.
     */
    public void close() {
        sessionFactory.close();
    }
}
