package ntg.microservice.inventoryservice.Service;

import ntg.microservice.inventoryservice.Repository.InventoryRepo;
import ntg.microservice.inventoryservice.dto.InventoryResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    @Transactional(readOnly = true)
    public List<InventoryResp> isInStock(List<String> skuCode) {
        return inventoryRepo.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResp.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
