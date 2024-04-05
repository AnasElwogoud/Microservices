package ntg.microservices.productservice.Service;

import lombok.extern.slf4j.Slf4j;
import ntg.microservices.productservice.Entity.Product;
import ntg.microservices.productservice.Repository.ProductRepo;
import ntg.microservices.productservice.dto.ProductRequest;
import ntg.microservices.productservice.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        productRepo.save(product);
        log.info("Product {} is Saved ✅", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
