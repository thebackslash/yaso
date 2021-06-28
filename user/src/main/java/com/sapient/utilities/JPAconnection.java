package com.sapient.utilities;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Priyadarshan Singh
 * 
 */
@Slf4j
public class JPAconnection {

    public static EntityManager getEntityManager() {

        try {
            return Persistence.createEntityManagerFactory("yaso").createEntityManager();
            
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return null;
        }
         
    }
}
