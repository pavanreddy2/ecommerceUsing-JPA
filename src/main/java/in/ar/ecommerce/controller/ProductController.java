package in.ar.ecommerce.controller;

import in.ar.ecommerce.dto.ProductResponse;
import in.ar.ecommerce.entity.Product;
import in.ar.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/searchProducts")
    public ResponseEntity<List<ProductResponse>> searchProducts(
            @RequestParam("name") String name
    ) {
        List<ProductResponse> products = productService.searchProducts(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
