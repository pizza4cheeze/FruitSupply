package grushevskaya.test.develop.FruitSupply.TO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SuppliedProductTO {
    Integer fruitId;
    Double weight;
}
