package fcode.binhtt.housewares_shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer userId;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
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
    @Column(name = "status")
    private Integer statusId;
    @Column(name = "role")
    private Integer roleId;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "lastupdate")
    private Date lastUpdate;
}
