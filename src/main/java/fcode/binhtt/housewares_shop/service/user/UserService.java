package fcode.binhtt.housewares_shop.service.user;

import fcode.binhtt.housewares_shop.entities.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User findUserByUsername(String username);

    Page<User> findAll(Pageable pageable);

    Optional<User> findUserById(Integer id);
}
