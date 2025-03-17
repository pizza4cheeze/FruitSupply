package grushevskaya.test.develop.FruitSupply.TO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReportedSuppliedFruitTO {
    String supplierName;
    LocalDate supplierDate;
    String fruitName;
    Double weight;
    Double price;
}
