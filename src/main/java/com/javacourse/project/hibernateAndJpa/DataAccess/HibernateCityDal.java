package com.javacourse.project.hibernateAndJpa.DataAccess;

import com.javacourse.project.hibernateAndJpa.entity.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateCityDal implements ICityDal{

    private EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//AOP - Acpect Oriented Programming
    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        return cities;
    }

    @Override
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.save(city);

    }

    @Override
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.save(city);

    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(city);
    }

    @Override
    public City getById(int Id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, Id);
        return city;
    }
}
