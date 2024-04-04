package ntg.microservices.productservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import ntg.microservices.productservices.Repository.ProductRepo;
import ntg.microservices.productservices.dto.ProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServicesApplicationTests {
//
////    @Container
////    static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
//
//    @Container
//    static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:8.0-debian");
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper; // convert object to Json
//    @Autowired
//    private ProductRepo productRepo;
//
//    @DynamicPropertySource
//    static void kafkaProperties(DynamicPropertyRegistry registry) {
////        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
//        registry.add("spring.datasource.url", () -> mySQLContainer.getJdbcUrl());
//        registry.add("spring.datasource.driverClassName", () -> mySQLContainer.getDriverClassName());
//        registry.add("spring.datasource.username", () -> mySQLContainer.getUsername());
//        registry.add("spring.datasource.password", () -> mySQLContainer.getPassword());
//        registry.add("spring.flyway.enabled", () -> "true");
//    }
//
//
//    @Test
//    void shouldCreateProduct() throws Exception {
//        ProductRequest productRequest = getProductRequest();
//        String productRequestString = objectMapper.writeValueAsString(productRequest);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(productRequestString))
//                .andExpect(status().isCreated());
//        Assertions.assertEquals(1, productRepo.findAll().size());
//    }
//
//    private ProductRequest getProductRequest() {
//        return ProductRequest.builder()
//                .name("Product 2")
//                .description("Description 2")
//                .price(BigDecimal.valueOf(2000)).build();
//    }

}
