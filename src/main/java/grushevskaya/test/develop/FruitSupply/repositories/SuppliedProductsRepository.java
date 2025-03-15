package grushevskaya.test.develop.FruitSupply.repositories;

import grushevskaya.test.develop.FruitSupply.models.SuppliedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliedProductsRepository extends JpaRepository<SuppliedProduct, Long> {
}
