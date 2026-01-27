package com.fsads3.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fsads3.entity.Product;
import com.fsads3.util.HibernateUtil;

public class InsertProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Electronics", 500, 50));
        session.save(new Product("Keyboard", "Electronics", 1500, 30));
        session.save(new Product("Chair", "Furniture", 3000, 15));
        session.save(new Product("Table", "Furniture", 7000, 5));
        session.save(new Product("Pen", "Stationery", 20, 200));

        tx.commit();
        session.close();
    }
}