package com.alten.challenge.vehiclesimulator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VehicleSimulatorApplication.class)
@WebAppConfiguration
@DataMongoTest
@ContextConfiguration(classes = {EmbeddedMongoTestConfiguration.class, EmbeddedMongoAutoConfiguration.class})

public class SpringTestSpringTest {

    @Test
    public void test() {
        // The same test than before
    }

}