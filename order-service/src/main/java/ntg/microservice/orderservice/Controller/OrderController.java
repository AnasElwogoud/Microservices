package ntg.microservice.orderservice.Controller;

import ntg.microservice.orderservice.Service.OrderService;
import ntg.microservice.orderservice.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) throws IllegalAccessException {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
