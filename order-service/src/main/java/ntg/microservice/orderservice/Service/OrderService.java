package ntg.microservice.orderservice.Service;

import lombok.extern.slf4j.Slf4j;
import ntg.microservice.orderservice.Entity.Order;
import ntg.microservice.orderservice.Entity.OrderLineItems;
import ntg.microservice.orderservice.Repository.OrderRepo;
import ntg.microservice.orderservice.dto.InventoryResp;
import ntg.microservice.orderservice.dto.OrderLineItemDto;
import ntg.microservice.orderservice.dto.OrderRequest;
import ntg.microservice.orderservice.feign.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderInterface orderInterface;


    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemDtoList().stream().map(this::mapToDto).toList();
        order.setOrderLineItemsList(orderLineItems);


        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();


        // call Inventory Service, and placeOrder if product is in
        List<InventoryResp> inStock = orderInterface.isInStock(skuCodes);

        boolean allProductsInStock = inStock.stream().allMatch(InventoryResp::isInStock);

//        InventoryResp[] inventoryRespArr = webClientBuilder.build().get()
//                .uri("http://inventory-service/api/inventory",
//                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
//                .retrieve()
//                .bodyToMono(InventoryResp[].class)
//                .block();
//
//        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryRespArr))
//                .allMatch(InventoryResp::isInStock);

        if (allProductsInStock) {
            orderRepo.save(order);
        } else {
            log.error("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemDto.getPrice());
        orderLineItems.setQuantity(orderLineItemDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItems;
    }
}
