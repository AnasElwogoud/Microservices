package ntg.microservice.orderservice.feign;

import ntg.microservice.orderservice.dto.InventoryResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("INVENTORY-SERVICE")
public interface OrderInterface {
    @GetMapping("/api/inventory")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResp> isInStock(@RequestParam List<String> skuCode);
}
