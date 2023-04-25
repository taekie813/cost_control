package sideProject.costControl.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sideProject.costControl.recipe.entity.Recipe;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userRecipeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    private Recipe recipe;
}
