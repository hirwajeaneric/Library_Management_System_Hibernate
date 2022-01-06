package com.library.controller;

import com.library.model.Client;
import java.util.List;
import com.library.model.Operations;
import com.library.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hirwa
 */
public class GenericDao<X> {
    Class<X> type;
    Session session;
    Transaction transaction;
    
    public GenericDao(Class<X> type) {
        this.type = type;
    }
    
    public void save(X obj){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    public void update(X obj){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    public void delete(X obj){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }
    
    public List<X> retrieveAll(X obj){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<X> theListofResults= session.createCriteria(obj.getClass()).list();
        transaction.commit();
        session.close();
        return theListofResults;
    }
    
    public List<Operations> searchClientName(String searchInput, Operations operations){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();
        
        Criteria crit = session.createCriteria(operations.getClass());
        crit.add(Restrictions.eq("clientNames",""+searchInput+""));
        List<Operations> searchResults = crit.list();
        
        transaction.commit();
        session.close();
        return searchResults;
    }

    String theName;
    public String FindClientId(String searchInput, Client client){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();

        Criteria criteriaOne = session.createCriteria(client.getFirstName()+" "+client.getLastName());
        criteriaOne.add(Restrictions.eq("registrationNumber", ""+searchInput+""));
        theName = criteriaOne.toString();
   
        transaction.commit();
        session.close();
        return theName;
    }
    
    
    public List<Operations> searchClientId(Operations operations){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();

        Criteria crit = session.createCriteria(operations.getClass());
        crit.add(Restrictions.eq("clientNames", ""+theName+""));
        List<Operations> searchResults = crit.list();
        
        transaction.commit();
        session.close();
        return searchResults;
    }
    
    public List<Operations> searchBook(String searchInput, Operations operations){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();
        
        Criteria crit = session.createCriteria(operations.getClass());
        crit.add(Restrictions.eq("bookTitle",""+searchInput+""));
        List<Operations> searchResults = crit.list();
        
        transaction.commit();
        session.close();
        return searchResults;
    }
    
    public List<Operations> searchBookCategory(String searchInput, Operations operations){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();
                
        Criteria crit = session.createCriteria(operations.getClass());
        crit.add(Restrictions.eq("bookCategory",""+searchInput+""));
        List<Operations> searchResults = crit.list();
        
        transaction.commit();
        session.close();
        return searchResults;
    }
    
    public List<Operations> searchDate(String searchInput, Operations operations){
        session=HibernateUtil.getSessionFactory().openSession();
        transaction=session.beginTransaction();
        
        Criteria crit = session.createCriteria(operations.getClass());
        crit.add(Restrictions.eq("bookTitle",""+searchInput+""));
        List<Operations> searchResults = crit.list();
        
        transaction.commit();
        session.close();
        return searchResults;
    }
}
