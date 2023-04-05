package ai.lentra.serviceImpl.verification_type;


import ai.lentra.modal.verification_type.Product;
import ai.lentra.repository.verification_type.ProductRepository;
import ai.lentra.service.verification_type.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public String getProductDetails(Integer institutionId, String productType, String profile) {
       Product product = productRepository.getProducts(institutionId,productType,profile);


        return product.getProfileName();
    }
}
