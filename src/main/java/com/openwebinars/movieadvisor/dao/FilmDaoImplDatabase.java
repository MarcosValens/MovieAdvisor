package com.openwebinars.movieadvisor.dao;

import com.openwebinars.movieadvisor.config.AppConfig;
import com.openwebinars.movieadvisor.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
@Primary
public class FilmDaoImplDatabase implements FilmDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AppConfig appConfig;

    @Override
    public Film findById(long id) {
        return null;
    }

    @Override
    public Collection<Film> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class); //indica que tipo de datos devolvera la query
        Root<Film> root = cq.from(Film.class); //indica sobre que tabla hara la query
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void insert(Film film) {

    }

    @Override
    public void edit(Film film) {

    }

    @Override
    public void delete(long id) {

    }
}
