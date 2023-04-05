package ai.lentra.repository.verification_type;

import ai.lentra.modal.verification_type.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.id, p.institution_id, p.profile_name, p.product_type FROM product p WHERE p.institution_id =?1 AND p.product_type=?2 AND profile_name=?3",nativeQuery = true)
    Product getProducts(Integer institutionId, String productType, String profile);
}
