package sideProject.costControl.ingredient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sideProject.costControl.recipe.entity.RecipeIngredient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int currentCost;

    private int pastCost;

    private float priceChangeRate;

    private boolean upDown;

    @Column(nullable = false)
    private float pricePerGram;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
}
