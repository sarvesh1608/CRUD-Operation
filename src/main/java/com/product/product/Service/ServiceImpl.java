package com.product.product.Service;
import com.product.product.DTO.ProductDTO;
import com.product.product.Entity.Product;
import com.product.product.Repository.ProductRepo;
import com.product.product.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            return productRepository.save(product);
        }

        @Override
        public Product getProductById(int id) {
            return productRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFound("Product not found with id: " + id));
        }

        @Override
        public List<Product> getAllProduct() {
            return productRepository.findAll();
        }

        @Override
        public Product updateProduct(int id, ProductDTO productDTO) {
            Product product = getProductById(id);
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            return productRepository.save(product);
        }

        @Override
        public void deleteProduct(int id) {
            Product product = getProductById(id);
            productRepository.delete(product);
        }
    }


