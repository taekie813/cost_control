package sideProject.costControl.indication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sideProject.costControl.recipe.entity.Recipe;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long indicationId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String foodType;

    @Column(nullable = false)
    private String origin;

    private String manufacturingCompany;

    private String vendor;

    private String dateOfManufacture;

    @Column(nullable = false)
    private String expirationDate;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String ingredientName;

    private int content;

    private String nurtrientImageUrl;

    @OneToOne(mappedBy = "indication", cascade = CascadeType.ALL)
    private Recipe recipe;
}
