package grushevskaya.test.develop.FruitSupply.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "fruits")
public class Apple extends Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Setter
    private String type;
    @Setter
    private String sort;

    public Apple(Integer id, String sort) {
        super(id, "Яблоко", sort);
    }

    public Apple(String sort) {
        super("Яблоко", sort);
    }
}
