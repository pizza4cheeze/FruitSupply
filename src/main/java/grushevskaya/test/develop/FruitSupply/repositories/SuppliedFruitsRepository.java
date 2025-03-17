package grushevskaya.test.develop.FruitSupply.repositories;

import grushevskaya.test.develop.FruitSupply.TO.ReportedSuppliedFruitTO;
import grushevskaya.test.develop.FruitSupply.TO.ReportedSupplyTo;
import grushevskaya.test.develop.FruitSupply.models.SuppliedFruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface SuppliedFruitsRepository extends JpaRepository<SuppliedFruit, Long> {

}
