import com.alten.challenge.vehicleconnector.VehicleConnectorApplication;
import com.alten.challenge.vehicleconnector.dto.VehicleStatusReceiverDto;
import com.alten.challenge.vehicleconnector.repository.CustomersRepository;
import com.alten.challenge.vehicleconnector.repository.StatusRepository;
import com.alten.challenge.vehicleconnector.repository.VehiclesRepository;
import com.alten.challenge.vehicleconnector.service.imp.VehicleServiceImpl;
import com.alten.challenge.vehicleconnector.web.VehicleResources;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.lang.reflect.Executable;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = VehicleResources.class)
@Import(VehicleServiceImpl.class)
@SpringBootTest(classes = VehicleConnectorApplication.class)
public class VehicleResourceTest {
    @MockBean
    StatusRepository statusRepository;
    @MockBean
    CustomersRepository customersRepository;
    @MockBean
    VehiclesRepository vehiclesRepository;


    private WebTestClient client = WebTestClient.bindToServer()
            .baseUrl("http://localhost:9202/api/v1")
            .build();



    @Test
    public void testCreateEmployee() {


        EntityExchangeResult<VehicleStatusReceiverDto> vehicleStatusReceiverDtoEntityExchangeResult = client.get()
                .uri("/get-all-vehicle")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
                .expectBody(VehicleStatusReceiverDto.class).returnResult();

        System.out.println(vehicleStatusReceiverDtoEntityExchangeResult);
    }
}
