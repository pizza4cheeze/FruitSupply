package grushevskaya.test.develop.FruitSupply.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    private Double value;
    @Setter
    private Integer fruitId;
    @Setter
    private LocalDate actionStartDate;
    @Setter
    private LocalDate actionEndDate;
    @Setter
    private Integer supplierId;

    public Price(Double value, Integer fruitId, LocalDate actionStartDate, LocalDate actionEndDate, Integer supplierId) {
        this.value = value;
        this.fruitId = fruitId;
        this.actionStartDate = actionStartDate;
        this.actionEndDate = actionEndDate;
        this.supplierId = supplierId;
    }
}
