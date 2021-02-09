package com.alten.challenge.vehiclesimulator;

import com.alten.challenge.vehiclesimulator.model.Customer;
import com.alten.challenge.vehiclesimulator.model.Vehicle;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@Configuration
@EnableMongoRepositories(
        basePackageClasses = {
                Vehicle.class, Customer.class
        })
@Import({MongoProperties.class, EmbeddedMongoProperties.class})
public class EmbeddedMongoTestConfiguration extends AbstractMongoConfiguration {

    private static final String DATABASE_NAME = "test";

    @Autowired
    private MongodStarter mongodStarter;

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Bean
    public MongodStarter mongodStarter() {
        return MongodStarter.getDefaultInstance();
    }


    @Override
    public MongoClient mongoClient() {
        try {
            MongodExecutable mongodExecutable = mongodStarter.prepare(new MongodConfigBuilder()
                    .version(Version.V3_4_3)
                    .net(new Net("localhost", 12345, Network.localhostIsIPv6()))
                    .build());
            MongodProcess ngodProcess = mongodExecutable.start();
            return  new MongoClient("localhost", 12345);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}