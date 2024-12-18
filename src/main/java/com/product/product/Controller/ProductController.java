package com.product.product.Controller;

import com.product.product.DTO.ProductDTO;
import com.product.product.Entity.Product;
import com.product.product.Exception.ResourceNotFound;
import com.product.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("productdb")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            Product product = productService.createProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error creating product: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        try {
            Product product = (Product) productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found: " + ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> product = productService.getAllProduct();
            return ResponseEntity.ok(product);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching products: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDTO);
            return ResponseEntity.ok(updatedProduct);
        } catch (ResourceNotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
        } catch (ResourceNotFound ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // Local Exception Handler for this Controller
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}



