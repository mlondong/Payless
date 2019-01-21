package demo.Payless.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	  private static final SessionFactory sessionFactory;

	    static
	    {
	        try
	        {
	         sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory(); 
		    }
	        catch (HibernateException he)
	        {
	            System.err.println("Ocurrio un error en la inicialización de la SessionFactory: " + he);
	            throw new ExceptionInInitializerError(he);
	        }
	    }

	    public static SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }

}
