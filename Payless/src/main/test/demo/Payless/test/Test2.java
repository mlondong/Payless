package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.Payless.dao.AbstractDAO;
import demo.Payless.model.CareProduct;
import demo.Payless.model.Consumer;
import demo.Payless.model.MeatProduct;
import demo.Payless.model.MilkProduct;
import demo.Payless.model.Trader;

public class Test2 {
	public static void main(String [] arg){
		testDB();
		testEntity();
		testpersistenceHibernate();
		testpersistenceJPA();
	}
	
	
	public static void testpersistenceJPA(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/*
		/*se crea el objeto a persistir*/
		//Consumer c = new Consumer("JPA", "11111", 1000, "JPAA", "JPA2");
		MilkProduct c =  new MilkProduct("MP23", "Leche Entera", "Celema",  50);

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		//c = em.find(Consumer.class, new Long(2));
		//System.out.println("consulta Employee :- " + c );

	}


	public static void testProduct(){

		/*TEST ALMACENAMIENTO DE PRODUCTOS Y SUS TIPOS */
		//test con hibernate.cfg


		MeatProduct mp1 = new MeatProduct("MPJU123", "Carne de vaca", "Angus",  10, "Vaca", new Date() );
		MilkProduct mp2 =  new MilkProduct("MP23", "Leche Entera", "Celema",  50 );
		MeatProduct mp3 = new MeatProduct("MPAA123", "Carne de vaca", "Angus",  10, "Vaca", new Date() );
		MeatProduct mp4 = new MeatProduct("MPCP121", "Carne de vaca", "Brangus",  10, "Vaca", new Date() );
		MeatProduct mp5 = new MeatProduct("MP1212", "Carne de Pollo", "Pollo",  10, "Pollo", new Date() );



		AbstractDAO.almacenaEntidad(mp1);
		AbstractDAO.almacenaEntidad(mp2);
		AbstractDAO.almacenaEntidad(mp3);
		AbstractDAO.almacenaEntidad(mp4);
		AbstractDAO.almacenaEntidad(mp5);


		CareProduct cp = new CareProduct("CPJU123", "Jabon de bano", "Dove",  50);
		AbstractDAO.almacenaEntidad(cp);


		MilkProduct m =  new MilkProduct("MP23", "Leche Entera", "Celema",  50);
		AbstractDAO.almacenaEntidad(m);


	}


	
	
	public static void testpersistenceHibernate(){
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

		Trader t = new Trader("sourise", "1234564",98888888,null);
		AbstractDAO.almacenaEntidad(t);

	}

	
}
