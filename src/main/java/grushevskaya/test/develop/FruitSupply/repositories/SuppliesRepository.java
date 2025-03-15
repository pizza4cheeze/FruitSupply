package grushevskaya.test.develop.FruitSupply.repositories;

import grushevskaya.test.develop.FruitSupply.models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliesRepository extends JpaRepository<Supply, Long> {
}
