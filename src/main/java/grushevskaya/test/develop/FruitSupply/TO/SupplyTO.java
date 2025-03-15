package grushevskaya.test.develop.FruitSupply.TO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SupplyTO {
    LocalDate date;
    Integer supplierId;
    List<SuppliedProductTO> suppliedProductsListTO;

}
