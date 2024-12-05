package in.ar.ecommerce.service;

import in.ar.ecommerce.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> searchProducts(String name);
}
