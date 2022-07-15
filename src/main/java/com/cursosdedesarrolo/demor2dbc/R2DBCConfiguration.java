package com.cursosdedesarrolo.demor2dbc;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
@EnableR2dbcRepositories
class R2DBCConfiguration extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        return new H2ConnectionFactory(
                io.r2dbc.h2.H2ConnectionConfiguration.builder()
                        .url("r2dbc:h2:mem:///testdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;")
                        .build()
        );
    }
    /*
    @Bean
    public ConnectionFactoryInitializer initializer() {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory());

        var databasePopulator = new CompositeDatabasePopulator();
        databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }
     */
}
