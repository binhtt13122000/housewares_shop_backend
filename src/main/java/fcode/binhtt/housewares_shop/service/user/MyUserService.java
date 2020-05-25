package fcode.binhtt.housewares_shop.service.user;

import fcode.binhtt.housewares_shop.constants.UserDetail;
import fcode.binhtt.housewares_shop.repositories.UserRepository;
import fcode.binhtt.housewares_shop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new UserDetail(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
