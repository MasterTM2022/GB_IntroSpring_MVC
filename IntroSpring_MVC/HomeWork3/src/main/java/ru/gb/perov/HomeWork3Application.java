package ru.gb.perov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeWork3Application {

    private static SessionFactory factory;

    public static void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeWork3Application.class, args);
        try {
            init();

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println(session.get(Product.class, 3L).toString());
            System.out.println(session.get(Product.class, 7L).toString());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

}
