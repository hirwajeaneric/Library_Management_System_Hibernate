package library.controller;

import java.util.List;
import library.model.BookCategory;
import library.utils.HibernateUtil;
import org.hibernate.*;

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
    
    public List<BookCategory> retrieveCategoryNames(BookCategory bookCats){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<BookCategory> theListofCategoryNames= session.createCriteria(bookCats.getCategoryName()).list();
        transaction.commit();
        session.close();
        return theListofCategoryNames;
    }
    
}
