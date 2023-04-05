package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.ProductConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductConfigRepository extends JpaRepository<ProductConfigEntity, Integer> {

    ProductConfigEntity findByProductId(Long productId);
    ProductConfigEntity findByProductType(String productType);
}
