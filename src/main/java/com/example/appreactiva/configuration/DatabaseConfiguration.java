
/*package com.example.appreactiva.configuration;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {

    @Value("\\${spring.data.mysql.host}")
    String host;
    @Value("\\${spring.data.mysql.port}")
    String port;
    @Value("\\${spring.data.mysql.database}")
    String database;
    @Value("\\${spring.data.mysql.username}")
    String username;
    @Value("\\${spring.data.mysql.password}")
    String password;

    @Override
    public ConnectionFactory connectionFactory() {
        return  MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
                .host(host)
                .port(Integer.parseInt(port))
                .database(database)
                .username(username)
                .password(password)
                .build());
    }

}

 */
