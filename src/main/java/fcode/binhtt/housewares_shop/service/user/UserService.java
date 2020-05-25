package fcode.binhtt.housewares_shop.service.user;

import fcode.binhtt.housewares_shop.entities.User;

public interface UserService {
    User findUserByUsername(String username);
}
