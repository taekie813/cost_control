package sideProject.costControl.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sideProject.costControl.user.entity.User;

public class UserDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private String name;
        private String nickName;
        private String email;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {
        private Long userId;
        private String nickName;

        public void addUserId(Long userId) {
            this.userId = userId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchPassword {
        private Long userId;
        private String currentPassword;
        private String nextPassword;
        private String nextPasswordCheck;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private String name;
        private String nickName;
        private String email;
        private User.UserStatus userStatus;

        public String getUserStatus() {
            return userStatus.getStatus();
        }
    }
}
