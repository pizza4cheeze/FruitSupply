package grushevskaya.test.develop.FruitSupply.services;

import grushevskaya.test.develop.FruitSupply.TO.SupplyTO;
import grushevskaya.test.develop.FruitSupply.models.Supply;
import grushevskaya.test.develop.FruitSupply.repositories.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliesService {

    @Autowired
    private final SuppliedProductsService suppliedProductsService;

    @Autowired
    private final SuppliesRepository suppliesRepository;

    public SuppliesService(SuppliedProductsService suppliedProductsService, SuppliesRepository suppliesRepository) {
        this.suppliedProductsService = suppliedProductsService;
        this.suppliesRepository = suppliesRepository;
    }

    public String takeASupply(SupplyTO supplyTO) {
        Supply savedSupply = suppliesRepository.save(new Supply(supplyTO.getDate(), supplyTO.getSupplierId()));
        Integer savedSupplyId = savedSupply.getId();

        suppliedProductsService.addSuppliedProducts(supplyTO.getSuppliedProductsListTO(), savedSupplyId);
        return "added a supply and its products";
    }
}
