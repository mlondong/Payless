package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DriverConnectionCreator;

import demo.Payless.dao.AbstractDAO;
import demo.Payless.dao.HibernateUtil;
import demo.Payless.model.CareProduct;
import demo.Payless.model.Consumer;
import demo.Payless.model.Invoice;
import demo.Payless.model.MeatProduct;
import demo.Payless.model.MilkProduct;
import demo.Payless.model.Product;
import demo.Payless.model.Purchase;
import demo.Payless.model.Trader;
import demo.Payless.model.Usser;

public class Test {


	public static void main(String[] arg){
		//testDB();
		//testEntity();
	
		//testpersistenceHibernate();
		testpersistenceJPA();
		
		//testConsumerAndPurchase();

		
		//testConsumerCircuit();
		//testInvoice();
		//testProduct();
		//testTreader();
	}


	public static void testTreader(){
		/*CIRCUITO COMPLETO DE TRADER*/
		Trader trader1 = new Trader("sourise", "1234564", 132555  );
		Invoice invoice1 = new Invoice();
		invoice1.setDateInvoice(new Date());
		invoice1.addProduct(new MeatProduct("MP1212", "Carne de XXX", "Pollo", 50, 10, "Pollo", new Date()));
		invoice1.addProduct(new MeatProduct("MPJU123", "Carne de XXXX", "Angus", 50, 10, "Vaca", new Date() ));
		invoice1.addProduct(new MilkProduct("MP23", "Leche XXX", "Celema", 100, 50 ));
		trader1.addInvoice(invoice1);
		AbstractDAO.almacenaEntidad(trader1);

	
	}
	
	
	public static void testConsumerCircuit(){
		/*TESTDE CIRCUITO COMPLETO DE CONSUMER EN COMPRA Y CREACION*/
		/*consumer con 1 compra y 3 productos*/
		Consumer consumer1 = new Consumer("XMEN", "0000001", 111111, "PEdro", "Sanchez");
		Purchase compra1 = new Purchase(new Date(),21563);
		compra1.getProducts().add(new MeatProduct("MP1212", "Carne de Pollo", "Pollo", 50, 10, "Pollo", new Date()));
		compra1.getProducts().add(new MeatProduct("MPCP121", "Carne de vaca", "Brangus", 50, 10, "Vaca", new Date()));
		compra1.getProducts().add(new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 ) );
		consumer1.getPurchase().add(compra1);
		AbstractDAO.almacenaEntidad(consumer1);

		/*consumer con 2 commpras y 3  productos*/
		Consumer consumer2 = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		
		Purchase compra2 = new Purchase(new Date(),5555);
		compra2.getProducts().add(new CareProduct("CPJU123", "Jabon de bano", "Dove", 100, 50));
		
		Purchase compra3 = new Purchase(new Date(),54212);
		compra3.getProducts().add(new CareProduct("CNIP00", "Champu", "Jhonsson", 100, 50));
		compra3.getProducts().add(new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() ));
		
		consumer2.getPurchase().add(compra2);
		consumer2.getPurchase().add(compra3);
		AbstractDAO.almacenaEntidad(consumer2);


		/*consumer con 1 compra y 11 productos*/
		Consumer consumer3 = new Consumer("Lorena", "1021707", 22222, "Lorena", "londono");
		Purchase compra4 = new Purchase(new Date(),4444);
		compra4.getProducts().add(new MilkProduct("MP23", "Leche Deslactosada", "Celema", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MP24", "Leche Entera", "Celema", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MP25", "Leche Entera", "Colanta", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MP26", "Leche Deslactosada", "Colanta", 1000, 503 ));
		compra4.getProducts().add(new MilkProduct("MP29", "Leche Cruda", "Alqueria", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MP28", "Leche Cabra", "Alqueria", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MP285", "Leche saborizada", "Nequick", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("MXX", "Leche Entera", "Algarra", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("ABP23", "Leche Entera", "San Felix", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("OP23", "Leche Deslactosada", "Serenisima", 100, 50 ));
		compra4.getProducts().add(new MilkProduct("OP523", "Leche Entera", "PortoBello", 100, 50 ));
		
		consumer3.getPurchase().add(compra4);
		AbstractDAO.almacenaEntidad(consumer3);

		
		
		Consumer consumer5 = new Consumer("Martica", "111112", 8566, "Martica", "Garcia");
		Purchase compra5 = new Purchase(new Date(),4444);
		consumer5.getPurchase().add(compra5);
		AbstractDAO.almacenaEntidad(consumer5);

	
	} 

	
	public static void testInvoice(){

		Invoice in = new Invoice();
		in.setDateInvoice(new Date());
		in.addProduct(new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() ));
		in.addProduct(new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 ));

		AbstractDAO.almacenaEntidad(in);

	}


	public static void testProduct(){

		/*TEST ALMACENAMIENTO DE PRODUCTOS Y SUS TIPOS */
		
		MeatProduct mp1 = new MeatProduct("MPJU123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() );
		MilkProduct mp2 =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50 );
		MeatProduct mp3 = new MeatProduct("MPAA123", "Carne de vaca", "Angus", 50, 10, "Vaca", new Date() );
		MeatProduct mp4 = new MeatProduct("MPCP121", "Carne de vaca", "Brangus", 50, 10, "Vaca", new Date() );
		MeatProduct mp5 = new MeatProduct("MP1212", "Carne de Pollo", "Pollo", 50, 10, "Pollo", new Date() );

		AbstractDAO.almacenaEntidad(mp1);
		AbstractDAO.almacenaEntidad(mp2);
		AbstractDAO.almacenaEntidad(mp3);
		AbstractDAO.almacenaEntidad(mp4);
		AbstractDAO.almacenaEntidad(mp5);


		CareProduct cp = new CareProduct("CPJU123", "Jabon de bano", "Dove", 100, 50);
		AbstractDAO.almacenaEntidad(cp);


		MilkProduct m =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50);
		AbstractDAO.almacenaEntidad(m);


	}


	public static void testEntity(){
		/*TESTDE HIBERNATE*/
		//Consumer c = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		//AbstractDAO.almacenaEntidad(c);

		//Trader t = new Trader("sourise", "1234564", new ArrayList<E>());
		//AbstractDAO.almacenaEntidad(t);

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



	public static void testpersistenceJPA(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		/*
		/*se crea el objeto a persistir*/
		//Consumer c = new Consumer("JPA", "11111", 1000, "JPAA", "JPA2");
		MilkProduct c =  new MilkProduct("MP23", "Leche Entera", "Celema", 100, 50);
		
		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		//c = em.find(Consumer.class, new Long(2));
		//System.out.println("consulta Employee :- " + c );
		
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

}
