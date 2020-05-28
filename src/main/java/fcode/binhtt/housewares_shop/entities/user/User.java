package fcode.binhtt.housewares_shop.entities.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fcode.binhtt.housewares_shop.entities.cart.Cart;
import fcode.binhtt.housewares_shop.entities.comment.Comment;
import fcode.binhtt.housewares_shop.entities.imgproduct.ImageProduct;
import fcode.binhtt.housewares_shop.entities.rate.Rate;
import fcode.binhtt.housewares_shop.entities.role.Role;
import fcode.binhtt.housewares_shop.entities.userstatus.UserStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "[user]")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "[user_id]", nullable = false, unique = true)
    private Integer userId;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "[password]", nullable = false)
    private String password;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthday")
    private Date birthDay;
    @Column(name = "avatar_url")
    private String avtUrl;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "last_update")
    private Date lastUpdate;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @JsonManagedReference
    private Role role;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @JsonManagedReference
    private UserStatus userStatus;
    @OneToMany(mappedBy = "product")
    private List<Rate> products;
    @OneToMany(mappedBy = "product")
    private List<Comment> productList;

    @OneToMany(mappedBy="user")
    @JsonBackReference
    private List<Cart> cartList;
}
