package com.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.entity.Product;
import com.util.HibernateUtil;

public class HQLOperations {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1. Sort by Price ASC
        Query<Product> q1 = session.createQuery(
                "FROM Product p ORDER BY p.price ASC", Product.class);
        List<Product> list1 = q1.list();

        // 2. Sort by Price DESC
        Query<Product> q2 = session.createQuery(
                "FROM Product p ORDER BY p.price DESC", Product.class);

        // 3. Sort by Quantity DESC
        Query<Product> q3 = session.createQuery(
                "FROM Product p ORDER BY p.quantity DESC", Product.class);

        // 4. Pagination (First 3)
        Query<Product> q4 = session.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);

        // 5. Count Products
        Long total = session.createQuery(
                "SELECT COUNT(p) FROM Product p", Long.class)
                .uniqueResult();

        // 6. Min & Max Price
        Object[] minMax = session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p",
                Object[].class).uniqueResult();

        // 7. Price Range Filter
        Query<Product> q5 = session.createQuery(
                "FROM Product p WHERE p.price BETWEEN :min AND :max",
                Product.class);
        q5.setParameter("min", 500);
        q5.setParameter("max", 10000);

        session.close();
    }
}