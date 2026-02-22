package com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.Product;
import com.util.HibernateUtil;

public class InsertData {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Electronics", 500, 50));
        session.save(new Product("Keyboard", "Electronics", 1200, 30));
        session.save(new Product("Chair", "Furniture", 3500, 15));
        session.save(new Product("Table", "Furniture", 7000, 5));
        session.save(new Product("Bottle", "Accessories", 300, 100));
        session.save(new Product("Notebook", "Stationery", 80, 200));

        tx.commit();
        session.close();

        System.out.println("Data Inserted Successfully!");
    }
}