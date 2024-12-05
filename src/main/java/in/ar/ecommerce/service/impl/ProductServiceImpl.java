package in.ar.ecommerce.service.impl;

import in.ar.ecommerce.dto.ProductResponse;
import in.ar.ecommerce.entity.Product;
import in.ar.ecommerce.repository.ProductRepository;
import in.ar.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> searchProducts(String name) {
        List<Product> products = productRepository.searchProductSQL(name);
        List<ProductResponse> productResponses =
                products.stream().map(this::mapToProduct).collect(Collectors.toList());
        //map(this::mapToProduct): -Transforms each Product object in the stream to a ProductResponse using the mapToProduct method.
        return productResponses;


    }
    private ProductResponse mapToProduct(Product product){
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setSku(product.getSku());
            response.setDescription(product.getDescription());
            response.setActice(product.isActice());
            response.setImageUrl(product.getImageUrl());
            response.setDateCreated(product.getDateCreated());
            response.setLastUpdated(product.getLastUpdated());
            response.setProductCategory(product.getProductCategory());

            return response;
    }
}
