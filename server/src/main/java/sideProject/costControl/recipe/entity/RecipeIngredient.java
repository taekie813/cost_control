package sideProject.costControl.recipe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sideProject.costControl.ingredient.entity.Ingredient;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeIngredientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;
}
