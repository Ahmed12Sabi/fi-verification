package ai.lentra.repository.masterconfig;

import ai.lentra.modal.masterconfig.ProductConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductConfigRepository extends JpaRepository<ProductConfigEntity, Integer> {

    ProductConfigEntity findByProductId(Long productId);
    ProductConfigEntity findByProductType(String productType);
    @Query(value = "SELECT * FROM product_config p WHERE p.product_type=?1 and p.profile_name =?2 and p.product_id not in (?3) " , nativeQuery = true)

    ProductConfigEntity findByProductTypeAndProfileNameAndProductIdNotIn(String productType,String profileName, Long id);

    ProductConfigEntity findByProductTypeAndProfileName(String productType, String profile);
}
