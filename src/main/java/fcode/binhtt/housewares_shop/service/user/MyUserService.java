package fcode.binhtt.housewares_shop.service.user;

import fcode.binhtt.housewares_shop.repositories.UserRepository;
import fcode.binhtt.housewares_shop.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }
}
