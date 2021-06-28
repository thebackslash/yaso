package com.sapient.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sapient.contracts.IUser;
import com.sapient.entities.User;
import com.sapient.utilities.JPAconnection;

/**
 * @author Priyadarshan Singh
 * 
 */
public class UserService implements IUser {

    static final String EMAIL = "email";
    static final String USERNAME = "userName";
    static final String PASSWORD = "password";
    static final String RATING = "rating";
    static final String ID = "id";
    static final String SALT = "salt";

    EntityManager em;
    CriteriaBuilder cb;
    CriteriaQuery<User> cq;
    Root<User> rootUser;

    public UserService() {
        em = JPAconnection.getEntityManager();
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(User.class);
        rootUser = cq.from(User.class);
    }

    @Override
    public boolean createUser(String email, String password, String username) {
        try {

            cq.where(cb.or(cb.equal(rootUser.get(USERNAME), username), cb.equal(rootUser.get(EMAIL), email)));

            List<User> resultList = em.createQuery(cq).getResultList();

            if (resultList.isEmpty()) {
                User user = new User(email, password, username);
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUser(String email) {

        cq.where(cb.equal(rootUser.get(EMAIL), email));

        cq.select(cb.construct(User.class, rootUser.get(USERNAME), rootUser.get(ID), rootUser.get(EMAIL),
                rootUser.get(RATING)));

        User user = null;
        user = em.createQuery(cq).getResultList().stream().findFirst().orElse(null);
        return user;
    }

    @Override
    public User getUser(int id) {

        cq.where(cb.equal(rootUser.get(ID), id));

        cq.select(cb.construct(User.class, rootUser.get(USERNAME), rootUser.get(ID), rootUser.get(EMAIL),
                rootUser.get(RATING)));

        User user = null;
        user = em.createQuery(cq).getResultList().stream().findFirst().orElse(null);
        return user;

    }

    @Override
    public List<User> getUsers() {
        cq.select(cq.from(User.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public boolean validateCredentials(String email, String password) {

        cq.where(cb.equal(rootUser.get(EMAIL), email));

        cq.select(cb.construct(User.class, rootUser.get(PASSWORD), rootUser.get(SALT)));

        User secureUser = null;

        secureUser = em.createQuery(cq).getResultList().stream().findFirst().orElse(null);

        return secureUser != null && secureUser.checkPassword(password);

    }

}
