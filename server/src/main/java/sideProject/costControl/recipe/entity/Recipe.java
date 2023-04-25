package sideProject.costControl.recipe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sideProject.costControl.indication.entity.Indication;
import sideProject.costControl.user.entity.UserRecipe;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeId;

    @Column(nullable = false)
    private float lossFactor;

    @Column(nullable = false)
    private int requiredAmount;

    @Column(nullable = false)
    private int orderQuantity;

    @Column(nullable = false)
    private float totalIngredient;

    @Column(nullable = false)
    private float conversionPrice;

    @Column(nullable = false)
    private int totalCost;

    @CreatedDate
    @Column(name = "CREATE_AT", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private boolean isPublic;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<UserRecipe> userRecipeList = new ArrayList<>();

    @OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredientList = new ArrayList<>();

    @OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Indication indication;
}
