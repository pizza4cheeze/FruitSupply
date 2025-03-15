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
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    private LocalDate date;
    @Setter
    private Integer supplierId;

    public Supply(LocalDate date, Integer supplierId) {
        this.date = date;
        this.supplierId = supplierId;
    }
}
