package it.unical.inf.uem.hib.util;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;

import it.unical.inf.uem.hib.domain.City;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static{
		try{
			sessionFactory=new Configuration()
			.addPackage("it.unical.inf.uem.hib.domain")
			.configure()
			.addAnnotatedClass(City.class)
			.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//si devono aggiungere tutte le classi che vogliamo siano utilizzate nel db

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
