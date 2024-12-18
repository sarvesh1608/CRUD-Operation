package com.product.product.Service;

import com.product.product.DTO.ProductDTO;
import com.product.product.Entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);

    Product getProductById(int id);

    List<Product> getAllProduct();

    Product updateProduct(int id, ProductDTO productDTO);

    void deleteProduct(int id);
}



