package ntg.microservice.inventoryservice;

import ntg.microservice.inventoryservice.Entity.Inventory;
import ntg.microservice.inventoryservice.Repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepo inventoryRepo) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_16");
            inventory.setQuantity(200);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_16_red");
            inventory1.setQuantity(0);
            inventoryRepo.save(inventory);
            inventoryRepo.save(inventory1);
        };
    }
}
