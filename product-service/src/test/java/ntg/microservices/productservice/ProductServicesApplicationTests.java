package ntg.microservices.productservice;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
