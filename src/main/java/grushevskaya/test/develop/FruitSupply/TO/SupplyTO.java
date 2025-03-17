package grushevskaya.test.develop.FruitSupply.TO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SupplyTO {
    LocalDate date;
    Integer supplierId;
    List<SuppliedFruitTO> suppliedFruitsListTO;

}
