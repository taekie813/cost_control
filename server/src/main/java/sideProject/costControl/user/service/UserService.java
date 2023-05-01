package sideProject.costControl.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideProject.costControl.exception.BusinessLogicException;
import sideProject.costControl.exception.ExceptionCode;
import sideProject.costControl.user.entity.User;
import sideProject.costControl.user.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        verifiedExistEmail(user.getEmail());
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User findUser = findVerifiedUser(user.getUserId());

        Optional.ofNullable(findUser.getNickName())
                .ifPresent(findUser::setNickName);
        Optional.ofNullable(findUser.getUserStatus())
                .ifPresent(findUser::setUserStatus);

        return userRepository.save(findUser);
    }

    public User findUser(long userId) {
        return findVerifiedUser(userId);
    }

    public Page<User> findUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page,size, Sort.by("userId").descending()));
    }

    public void deleteUser(long userId) {
        User findUser = findVerifiedUser(userId);

        userRepository.delete(findUser);
    }

    public User findVerifiedUser(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User findUser = optionalUser.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.NOT_FOUND_EXCEPTION));

        return findUser;
    }

    public void verifiedExistEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }
}
