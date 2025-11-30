package com.cursos.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // Habilita al gestor para usar los @Transactional en la aplicación Spring
@ComponentScan(basePackages = {"com.cursos.repository","com.cursos.service"}) // Escanea el paquete base para detectar componentes de Spring
@Configuration
@PropertySource("classpath:application.properties") // Carga las propiedades desde el archivo application.properties
public class SpringConfig {
	//Propiedad que se establece en el archivo application.properties que luego llama al server.xml name="refcursos"	
	@Value("${ref-jndi}")
	private String refData;
	
	//Configuracion del DataSource: que se obtiene del JNDI que se ha configurado en el servidor de aplicaciones (Tomcat, Wildfly, etc.)
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		return dsLookup.getDataSource(refData);
	}
	
	//Adapatador Hibernate: permite integrar Hibernate con Spring
	//y configurar aspectos específicos de Hibernate, para poder trabajar con el motor de persistencia MySQL.
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}
	
	//Configuración del EntityManagerFactory: que es el componente principal de JPA 
	//para interactuar con la base de datos.
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("cursosPU");
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.cursos.model");
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}
	
	//Gestor de transacciones de JPA: que se encarga de gestionar las transacciones de la base de datos.
	//Configura el EntityManagerFactory: El gestor necesita un EntityManagerFactory para coordinar operaciones de base de datos 
	@Bean
	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory.getObject());
		return transactionManager;
	}
	
	
}
