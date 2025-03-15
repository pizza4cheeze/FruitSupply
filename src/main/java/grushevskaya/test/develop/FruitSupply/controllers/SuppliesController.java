package grushevskaya.test.develop.FruitSupply.controllers;

import grushevskaya.test.develop.FruitSupply.TO.SupplyTO;
import grushevskaya.test.develop.FruitSupply.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuppliesController {

    @Autowired
    private final SuppliesService suppliesService;

    public SuppliesController(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }

    @PostMapping(path = "/take-supply")
    public String takeASupply(@RequestBody SupplyTO supplyTO) {
        return suppliesService.takeASupply(supplyTO);
    }

}
