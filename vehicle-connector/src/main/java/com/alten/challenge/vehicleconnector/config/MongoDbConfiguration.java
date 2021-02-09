package com.alten.challenge.vehicleconnector.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import static com.alten.challenge.vehicleconnector.constants.PropertiesKey.*;


@Configuration
@EnableReactiveMongoRepositories("com.alten.challenge.vehicleconnector.**")
public class MongoDbConfiguration extends AbstractReactiveMongoConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(MongoDbConfiguration.class);
    @Value(SPRING_DATA_MONGODB_DATABASE)
    private String mongoDatabase;
    @Value(SPRING_DATA_MONGODB_HOST)
    private String host;
    @Value(SPRING_DATA_MONGODB_PORT)
    private String port;



    @Override
    protected String getDatabaseName() {
        return mongoDatabase;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(MongoClientSettings.builder().applyConnectionString(new ConnectionString("mongodb://".concat(host).concat(":").concat(port))).build());
    }
}
