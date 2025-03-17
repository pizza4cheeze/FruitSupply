package grushevskaya.test.develop.FruitSupply.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "supplied_fruits")
public class SuppliedFruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    private Integer fruitId;
    @Setter
    private Double weight;

    // id поставки в которой пришел товар
    @Setter
    private Integer supplyId;

    public SuppliedFruit(Integer fruitId, Double weight, Integer supplyId) {
        this.fruitId = fruitId;
        this.weight = weight;
        this.supplyId = supplyId;
    }
}
