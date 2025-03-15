package grushevskaya.test.develop.FruitSupply.services;

import grushevskaya.test.develop.FruitSupply.TO.SuppliedProductTO;
import grushevskaya.test.develop.FruitSupply.models.SuppliedProduct;
import grushevskaya.test.develop.FruitSupply.repositories.SuppliedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliedProductsService {
    @Autowired
    private final SuppliedProductsRepository suppliedProductsRepository;

    public SuppliedProductsService(SuppliedProductsRepository suppliedProductsRepository) {
        this.suppliedProductsRepository = suppliedProductsRepository;
    }

    public void addSuppliedProducts(List<SuppliedProductTO> suppliedProductsListTO, Integer supplyId) {
        for (SuppliedProductTO suppliedProductTO : suppliedProductsListTO) {
            suppliedProductsRepository.save(new SuppliedProduct(suppliedProductTO.getFruitId(), suppliedProductTO.getWeight(), supplyId));
        }
    }
}
