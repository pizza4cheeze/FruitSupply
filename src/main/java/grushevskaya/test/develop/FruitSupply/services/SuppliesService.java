package grushevskaya.test.develop.FruitSupply.services;

import grushevskaya.test.develop.FruitSupply.TO.ReportedSuppliedFruitTO;
import grushevskaya.test.develop.FruitSupply.TO.SupplyTO;
import grushevskaya.test.develop.FruitSupply.models.Supply;
import grushevskaya.test.develop.FruitSupply.repositories.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@Service
public class SuppliesService {

    @Autowired
    private final SuppliedFruitsService suppliedFruitsService;

    @Autowired
    private final SuppliesRepository suppliesRepository;


    public SuppliesService(SuppliedFruitsService suppliedFruitsService, SuppliesRepository suppliesRepository, JdbcTemplate jdbcTemplate, ReportDocumentService reportDocumentService) {
        this.suppliedFruitsService = suppliedFruitsService;
        this.suppliesRepository = suppliesRepository;
    }

    public String takeASupply(SupplyTO supplyTO) {
        Supply savedSupply = suppliesRepository.save(new Supply(supplyTO.getDate(), supplyTO.getSupplierId()));
        Integer savedSupplyId = savedSupply.getId();

        suppliedFruitsService.addSuppliedFruits(supplyTO.getSuppliedFruitsListTO(), savedSupplyId);
        return "added a supply and its fruits";
    }

    public List<ReportedSuppliedFruitTO> getReportByPeriod(LocalDate startDate, LocalDate endDate) throws IOException {
        return suppliedFruitsService.getSuppliesByDates(startDate, endDate);
    }

}
