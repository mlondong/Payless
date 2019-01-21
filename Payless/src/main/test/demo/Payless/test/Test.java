package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DriverConnectionCreator;

import demo.Payless.dao.AbstractDAO;
import demo.Payless.dao.HibernateUtil;
import demo.Payless.model.Consumer;
import demo.Payless.model.Trader;

public class Test {


	public static void main(String[] arg){
		//testDB();
		//testEntity();
		testpersistence();
	}

	public static void testDB(){
		String jdbc="jdbc:mysql://localhost:3306/dbpayless?useSSL=false";
		String  user= "payless";
		String pass="payless123";
		System.out.println("Conectando a BD...");

		try{
			Connection c = DriverManager.getConnection(jdbc, user, pass);
			System.out.println("Conexion successful");

		}catch(Exception e){
			System.out.println("Error de conexion " + e);
		}

	}


	public static void testEntity(){
		/*TESTDE HIBERNATE*/
		Consumer c = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		AbstractDAO.almacenaEntidad(c);

		Trader t = new Trader("sourise", "1234564", 132555);
		AbstractDAO.almacenaEntidad(t);

	}


	public static void testpersistence(){
		SessionFactory factory;
		factory = new Configuration()
				.configure("hibernate/hibernate.cfg.xml")
				.addAnnotatedClass(Consumer.class)
				.buildSessionFactory();

		Session session = factory.openSession();
	
		
		Consumer c = new Consumer("mouse2", "11111", 1000, "Mauxxx", "londono");
		
		try {

			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();

		} finally  {

			factory.close();
		}


	}

}
