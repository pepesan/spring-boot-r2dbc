package com.cursosdedesarrolo.demor2dbc;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;


@SpringBootApplication
public class DemoR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoR2dbcApplication.class, args);
	}
	/*
	@Bean
	public ConnectionFactory connectionFactory() {
		return ConnectionFactories.get(
				"r2dbcs:mysql://root:root@127.0.0.1:3306/test?" +
						"zeroDate=use_round&" +
						"sslMode=verify_identity&" +
						"useServerPrepareStatement=true&" +
						"tlsVersion=TLSv1.3%2CTLSv1.2%2CTLSv1.1&" +
						"sslCa=%2Fpath%2Fto%2Fmysql%2Fca.pem&" +
						"sslKey=%2Fpath%2Fto%2Fmysql%2Fclient-key.pem&" +
						"sslCert=%2Fpath%2Fto%2Fmysql%2Fclient-cert.pem&" +
						"sslKeyPassword=key-pem-password-in-here"
		);
	}
	@Bean()
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		// This will create our database table and schema
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		// This will drop our table after we are done so we can have a fresh start next run
		initializer.setDatabaseCleaner(new ResourceDatabasePopulator(new ClassPathResource("cleanup.sql")));
		return initializer;
	}


	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);

		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
		initializer.setDatabasePopulator(populator);

		return initializer;
	}

	 */




}
