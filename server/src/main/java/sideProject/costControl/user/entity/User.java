package sideProject.costControl.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    String password;

    private String profileImageUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    UserStatus userStatus = UserStatus.USER_NEW;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRecipe> userRecipeList = new ArrayList<>();

    public enum UserStatus {
        USER_NEW("USER_NEW"),  // 신규 가입
        USER_ACTIVE("USER_ACTIVE"), // 활동중
        USER_SLEEP("USER_SLEEP"),  // 휴면 계정
        USER_QUIT("USER_QUIT"),  // 회원 탈퇴
        USER_BLOCK("USER_BLOCK"); // 회원 정지

        @Getter
        String status;

        UserStatus(String status) {
            this.status = status;
        }
    }
}
