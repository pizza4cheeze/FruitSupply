package grushevskaya.test.develop.FruitSupply.services;

import grushevskaya.test.develop.FruitSupply.TO.ReportedSuppliedFruitTO;
import grushevskaya.test.develop.FruitSupply.TO.SuppliedFruitTO;
import grushevskaya.test.develop.FruitSupply.models.SuppliedFruit;
import grushevskaya.test.develop.FruitSupply.repositories.SuppliedFruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliedFruitsService {

    @Autowired
    private final SuppliedFruitsRepository suppliedFruitsRepository;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public SuppliedFruitsService(SuppliedFruitsRepository suppliedFruitsRepository, JdbcTemplate jdbcTemplate) {
        this.suppliedFruitsRepository = suppliedFruitsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ReportedSuppliedFruitTO> getSuppliesByDates(LocalDate startDate, LocalDate endDate) {
        String sql = """
            SELECT sups.date, suppliers.name AS supplier_name, fr.type AS fruit_name,
                   sf.weight, p.value AS price
            FROM supplied_fruits AS sf
            JOIN supplies AS sups ON sups.id = sf.supply_id
            JOIN prices AS p ON p.fruit_id = sf.fruit_id AND p.supplier_id = sups.supplier_id
            JOIN fruits AS fr ON fr.id = sf.fruit_id
            JOIN suppliers AS suppliers ON suppliers.id = sups.supplier_id
            WHERE sups.date >= p.action_start_date AND sups.date <= p.action_end_date
            AND sups.date >= ? AND sups.date <= ?
            """;

        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, (rs, rowNum) -> {
            ReportedSuppliedFruitTO dto = new ReportedSuppliedFruitTO();
            dto.setSupplierDate(rs.getObject("date", LocalDate.class));
            dto.setSupplierName(rs.getString("supplier_name"));
            dto.setFruitName(rs.getString("fruit_name"));
            dto.setWeight(rs.getDouble("weight"));
            dto.setPrice(rs.getDouble("price"));
            return dto;
        });
    }

    public void addSuppliedFruits(List<SuppliedFruitTO> suppliedFruitsListTO, Integer supplyId) {
        List<SuppliedFruit> suppliedFruits = new ArrayList<>();
        for (SuppliedFruitTO suppliedFruitTO : suppliedFruitsListTO) {
            suppliedFruits.add(new SuppliedFruit(suppliedFruitTO.getFruitId(), suppliedFruitTO.getWeight(), supplyId));
        }
        suppliedFruitsRepository.saveAll(suppliedFruits);
    }
}
