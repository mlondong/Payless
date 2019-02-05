package demo.Payless.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

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
import demo.Payless.model.Stock;
import demo.Payless.model.StockProducts;
import demo.Payless.model.Trader;
import demo.Payless.model.Usser;

public class Test {


	public static void main(String[] arg){
		//testDB();
		//testEntity();
		//testpersistenceHibernate();
		//testpersistenceJPA();

		//testConsumerAndPurchase();
		//testConsumerCircuit();
		//testInvoice();
		//testProduct();


		
		//createUsersandProducts();
		
		
		
		//testTreader();
		//testStockProduct();

		//testTraderStockProduct();
		//testNewTraderStockProduct();
		testTraderComplete();
		
	}




	public static void createUsersandProducts(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Trader trader1 = new Trader("Trader1", "111111", 132555  );
		Trader trader2 = new Trader("Trader2", "2222", 132555  );
		Consumer consumer1 = new Consumer("Consumer1", "9999", 10217047, "Fabio", "londono");
		Consumer consumer2 = new Consumer("Consumer2", "888", 10217047, "Martha", "Garcia");
	
		em.persist(trader1);
		em.persist(trader2);
		em.persist(consumer1);
		em.persist(consumer2);
		
		MeatProduct mp1 = new MeatProduct("MP1", "Vaca", "Angus",  10, "Vaca", new Date() );
		MeatProduct mp2 = new MeatProduct("MP2", "Pollo", "Angus",  10, "Pollo", new Date() );
		MeatProduct mp3 = new MeatProduct("MP3", "Cerdo", "Cerdo",  10, "Cerdo", new Date() );
		MeatProduct mp4 = new MeatProduct("MP4", "Pez", "Pez",  10, "Pez", new Date() );
		
		em.persist(mp1);
		em.persist(mp2);
		em.persist(mp3);
		em.persist(mp4);
			
		MilkProduct mp5 =  new MilkProduct("MP5", "Leche Entera", "Celema",  50 );
		MilkProduct mp6 =  new MilkProduct("MP6", "Quesillo", "Celema",  50 );
		MilkProduct mp7 =  new MilkProduct("MP7", "Yogurth", "Celema",  50 );
	
		em.persist(mp5);
		em.persist(mp6);
		em.persist(mp7);
		
		CareProduct mp8 = new CareProduct("MP8", "Jabon de Manos", "Dove",  100);
		CareProduct mp9 = new CareProduct("MP9", "Shampoo", "Dove",  100);
		
		em.persist(mp8);
		em.persist(mp9);
		
		em.getTransaction().commit();
		em.close();		
		
	}
	
	
	
	public static void testTreader(){
		/*CIRCUITO COMPLETO DE TRADER*/
		Trader trader1 = new Trader("sourise", "1234564", 132555  );
		Invoice invoice1 = new Invoice();
		invoice1.setDateInvoice(new Date());
		invoice1.addProduct(new MeatProduct("MP1212", "Carne de XXX", "Pollo",  10, "Pollo", new Date()));
		invoice1.addProduct(new MeatProduct("MPJU123", "Carne de XXXX", "Angus",  10, "Vaca", new Date() ));
		invoice1.addProduct(new MilkProduct("MP23", "Leche XXX", "Celema",  50 ));
		trader1.addInvoice(invoice1);
		AbstractDAO.almacenaEntidad(trader1);//test con hibernate.cfg


	}


	public static void testConsumerCircuit(){
		/*TESTDE CIRCUITO COMPLETO DE CONSUMER EN COMPRA Y CREACION*/
		/*consumer con 1 compra y 3 productos*/
		////test con hibernate.cfg


		Consumer consumer1 = new Consumer("XMEN", "0000001", 111111, "PEdro", "Sanchez");
		Purchase compra1 = new Purchase(new Date(),21563);
		compra1.getProducts().add(new MeatProduct("MP1212", "Carne de Pollo", "Pollo",  10, "Pollo", new Date()));
		compra1.getProducts().add(new MeatProduct("MPCP121", "Carne de vaca", "Brangus",  10, "Vaca", new Date()));
		compra1.getProducts().add(new MilkProduct("MP23", "Leche Entera", "Celema",  50 ) );
		consumer1.getPurchase().add(compra1);
		AbstractDAO.almacenaEntidad(consumer1);

		/*consumer con 2 commpras y 3  productos*/
		Consumer consumer2 = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");

		Purchase compra2 = new Purchase(new Date(),5555);
		compra2.getProducts().add(new CareProduct("CPJU123", "Jabon de bano", "Dove",  50));

		Purchase compra3 = new Purchase(new Date(),54212);
		compra3.getProducts().add(new CareProduct("CNIP00", "Champu", "Jhonsson",  50));
		compra3.getProducts().add(new MeatProduct("MPJU123", "Carne de vaca", "Angus",  10, "Vaca", new Date() ));

		consumer2.getPurchase().add(compra2);
		consumer2.getPurchase().add(compra3);
		AbstractDAO.almacenaEntidad(consumer2);


		/*consumer con 1 compra y 11 productos*/
		Consumer consumer3 = new Consumer("Lorena", "1021707", 22222, "Lorena", "londono");
		Purchase compra4 = new Purchase(new Date(),4444);
		compra4.getProducts().add(new MilkProduct("MP23", "Leche Deslactosada", "Celema",  50 ));
		compra4.getProducts().add(new MilkProduct("MP24", "Leche Entera", "Celema",  50 ));
		compra4.getProducts().add(new MilkProduct("MP25", "Leche Entera", "Colanta",  50 ));
		compra4.getProducts().add(new MilkProduct("MP26", "Leche Deslactosada", "Colanta",  503 ));
		compra4.getProducts().add(new MilkProduct("MP29", "Leche Cruda", "Alqueria",  50 ));
		compra4.getProducts().add(new MilkProduct("MP28", "Leche Cabra", "Alqueria",  50 ));
		compra4.getProducts().add(new MilkProduct("MP285", "Leche saborizada", "Nequick",  50 ));
		compra4.getProducts().add(new MilkProduct("MXX", "Leche Entera", "Algarra",  50 ));
		compra4.getProducts().add(new MilkProduct("ABP23", "Leche Entera", "San Felix",  50 ));
		compra4.getProducts().add(new MilkProduct("OP23", "Leche Deslactosada", "Serenisima",  50 ));
		compra4.getProducts().add(new MilkProduct("OP523", "Leche Entera", "PortoBello",  50 ));

		consumer3.getPurchase().add(compra4);
		AbstractDAO.almacenaEntidad(consumer3);



		Consumer consumer5 = new Consumer("Martica", "111112", 8566, "Martica", "Garcia");
		Purchase compra5 = new Purchase(new Date(),4444);
		consumer5.getPurchase().add(compra5);
		AbstractDAO.almacenaEntidad(consumer5);


	} 


	public static void testInvoice(){

		//test con hibernate.cfg

		Invoice in = new Invoice();
		in.setDateInvoice(new Date());
		in.addProduct(new MeatProduct("MPJU123", "Carne de vaca", "Angus",  10, "Vaca", new Date() ));
		in.addProduct(new MilkProduct("MP23", "Leche Entera", "Celema",  50 ));

		AbstractDAO.almacenaEntidad(in);

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


	public static void testEntity(){
		/*TESTDE HIBERNATE*/
		Consumer c = new Consumer("mouse", "1234564", 10217047, "Mauricio", "londono");
		AbstractDAO.almacenaEntidad(c);

		Trader t = new Trader("sourise", "1234564",98888888);
		AbstractDAO.almacenaEntidad(t);

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
		MilkProduct c =  new MilkProduct("MP23", "Leche Entera", "Celema",  50);

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


	public static void testStockProduct(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");


		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//trae los productos
		MeatProduct p1 = em.getReference(MeatProduct.class, 1L);
		MeatProduct p2 = em.getReference(MeatProduct.class, 3L);
		MeatProduct p3 = em.getReference(MeatProduct.class, 4L);
		MeatProduct p4 = em.getReference(MeatProduct.class, 5L);
		MilkProduct p5 = em.getReference(MilkProduct.class, 7L);
		MilkProduct p6 = em.getReference(MilkProduct.class, 2L);


		Stock stock = new  Stock();
		stock.setDateStock(new Date());
		stock.getProducts().add(new StockProducts(stock, p1, 300));
		stock.getProducts().add(new StockProducts(stock, p2, 40));
		stock.getProducts().add(new StockProducts(stock, p3, 50));
		stock.getProducts().add(new StockProducts(stock, p4, 30));
		stock.getProducts().add(new StockProducts(stock, p5, 20));
		stock.getProducts().add(new StockProducts(stock, p6, 10));


		em.persist(stock);
		em.getTransaction().commit();

		//c = em.find(Consumer.class, new Long(2));
		//System.out.println("consulta Employee :- " + c );

	}

	
	public static void testNewTraderStockProduct(){
		
		/*NUEVO TRAIDER*/
		
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Trader td = new  Trader("TRADERMAURICE", "CUALQUIERCOAS", 1111);
		td.createStock();
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new CareProduct("CPJU123", "Jabon de bano", "Dove",  50),1000);
		td.addStockProducts(new CareProduct("XXX", "Jabon de bano", "jhonson",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Colanta",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		td.addStockProducts(new MilkProduct("MP23", "Leche Entera", "Celema",  50),1000);
		
		em.persist(td);
		em.getTransaction().commit();
		em.close();
	}	
	

	public static void testTraderStockProduct(){
		/* Create EntityManagerFactory hace uso del archivo persistence.xml en src/main/resources/meta-inf*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");

		/* Create EntityManager habre la transaccion  hace comit y cierra*/
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		/*CON TRADER CONOCIDO*/
		Trader t = em.getReference(Trader.class, 2L);

		MeatProduct p4 = em.getReference(MeatProduct.class, 5L);
		MilkProduct p5 = em.getReference(MilkProduct.class, 7L);
		MilkProduct p6 = em.getReference(MilkProduct.class, 2L);


		Stock stock = new  Stock();
		stock.setDateStock(new Date());
		stock.setTrader(t);
		stock.getProducts().add(new StockProducts(stock, p4, 300));
		stock.getProducts().add(new StockProducts(stock, p5, 40));
		stock.getProducts().add(new StockProducts(stock, p6, 50));

		em.persist(stock);
		em.getTransaction().commit();
		em.close();

	}

	
	public static void testTraderComplete(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		/* ESCENARIO 1 CREAR TRADER Y CREAR TODOS LOS OBJETOS DENTRO DE EL TRADER
		 * YA REALIZADO Y FUNCIONA
		 * */
		
		
		/* ESCENARIO 2 A PARTIR DE UN TRADER SE CREA UN STOCK Y DENTRO DE EE STOCK PRODUCTOS
		 * Y SE CREAN 2 INVOICES DE UN TRADER
		 * */
	
		/*Trader trader1= em.getReference(Trader.class, 1L);
		Stock stock = new Stock();
		stock.setTrader(trader1);
		stock.addProduct((MeatProduct)em.getReference(MeatProduct.class, 1L), 10);
		stock.addProduct((MeatProduct)em.getReference(MeatProduct.class, 2L), 20);
		stock.addProduct((MeatProduct)em.getReference(MeatProduct.class, 3L), 5);
		stock.addProduct((MeatProduct)em.getReference(MeatProduct.class, 4L), 5);
		stock.addProduct((MilkProduct)em.getReference(MilkProduct.class, 7L), 200);
		stock.addProduct((CareProduct)em.getReference(CareProduct.class, 8L), 50);
		stock.addProduct((CareProduct)em.getReference(CareProduct.class, 9L), 70);
		
		em.persist(stock);
		
		Invoice inv1 = new Invoice();
		inv1.setDateInvoice(new Date());
		inv1.addProduct((CareProduct)em.getReference(CareProduct.class, 9L));
		inv1.addProduct((MilkProduct)em.getReference(MilkProduct.class, 7L));
		trader1.addInvoice(inv1);
		
		Invoice inv2 = new Invoice();
		inv2.setDateInvoice(new Date());
		inv2.addProduct((MeatProduct)em.getReference(MeatProduct.class, 1L));
		trader1.addInvoice(inv2);
	
		em.persist(inv1);
		em.persist(inv2);
		*/
		/* ESCENARIO 3 EL TRADERMODIFICA LA CANTIDAD Y LOSPRODUCTOS DE SU STOCK
		 * */
		Trader trader1= em.getReference(Trader.class, 1L);
		System.out.println(trader1);
		
		
		/*Stock s = trader1.getStock();
		Collection<StockProducts> arr= s.getProducts();
        
		System.out.println("");
		
		for (Iterator i = arr.iterator(); i.hasNext(); ){
				System.out.println(i.next().hashCode());
		}	*/    
		
		
		
		em.getTransaction().commit();
		em.close();
		
		
		
	}
	
	
	
}//fin clase
