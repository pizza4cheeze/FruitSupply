package grushevskaya.test.develop.FruitSupply.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "fruits")
public class Pear extends Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    private String type;
    @Setter
    private String name;

    public Pear(Integer id, String name) {
        super(id, "Груша", name);
    }

    public Pear(String name) {
        super("Груша", name);
    }
}
